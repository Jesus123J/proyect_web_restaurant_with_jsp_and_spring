package com.proyect.racoonbrothers.service.impl;

import com.proyect.racoonbrothers.controller.rest.*;
import com.proyect.racoonbrothers.data.dao.BossDao;
import com.proyect.racoonbrothers.data.dto.*;
import com.proyect.racoonbrothers.data.entity.*;
import com.proyect.racoonbrothers.repository.*;
import com.proyect.racoonbrothers.controller.rest.BossOrderListResponse;
import com.proyect.racoonbrothers.service.*;
import com.proyect.racoonbrothers.util.LogUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BossServiceImpl implements BossService {

    @Autowired
    BossDao bossDao;
    @Autowired
    ISendPasswordEmail sendPasswordEmail;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    HistoryAttendanceRepository historyAttendanceRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    StockRepository stockRepository;
    @Autowired
    HistoryStockRepository historyStockRepository;

    @Override
    public BoosRegisterEmployeeResponse bossRegisterEmployee(BossRegisterEmployeeRequest bossRegisterEmployeeRequest) {
        LogUtil.info("bossRegisterEmployeeRequest -> " + bossRegisterEmployeeRequest);

//        Optional<PersonTb> personExist = personRepository.findByEmail(registerEmployeesRequest.getEmail());
        List<PersonTb> listPerson = personRepository.findAll();
        BaseResponse baseResponse = getResponse(listPerson,
                bossRegisterEmployeeRequest.getDni(),
                bossRegisterEmployeeRequest.getEmail(),
                bossRegisterEmployeeRequest.getCellphone(),
                bossRegisterEmployeeRequest.getName(),
                bossRegisterEmployeeRequest.getLastname(),
                bossRegisterEmployeeRequest.getMotherLastname());

        if (baseResponse.getStatus().equals(400)) {
            return new BoosRegisterEmployeeResponse(baseResponse.getStatus(), baseResponse.getMessage());
        }

        PersonTb newPerson = generatePerson(bossRegisterEmployeeRequest.getName(),
                bossRegisterEmployeeRequest.getLastname(),
                bossRegisterEmployeeRequest.getMotherLastname(),
                bossRegisterEmployeeRequest.getDni(),
                bossRegisterEmployeeRequest.getEmail(),
                bossRegisterEmployeeRequest.getCellphone());

        AccountTb newAccount = generateAccount(bossRegisterEmployeeRequest.getName(),
                bossRegisterEmployeeRequest.getEmail(),
                bossRegisterEmployeeRequest.getRole());

        sendPasswordEmail.sendPasswordEmail(bossRegisterEmployeeRequest.getEmail(), newAccount.getPassword());

        accountRepository.save(newAccount);

        newPerson.setIdAccount(newAccount.getId());

        personRepository.save(newPerson);


        return new BoosRegisterEmployeeResponse(200, "Se registró los datos del empleado");
    }

    @Override
    public BossEmployeeListResponse listBossEmployee() {
        BossEmployeeListResponse bossEmployeeListResponse = new BossEmployeeListResponse();
        List<BossEmployeeDto> listBossEmployee = bossDao.listResultBossEmployee();
        if (listBossEmployee.isEmpty()) {
            bossEmployeeListResponse.setStatus(204);
            bossEmployeeListResponse.setMessage("No se encontró ningún empleado");
        } else {
            bossEmployeeListResponse.setStatus(200);
            bossEmployeeListResponse.setMessage("Se listan los empleados");
        }
        bossEmployeeListResponse.setBoosEmployees(listBossEmployee);
        return bossEmployeeListResponse;
    }

    @Override
    public BossRegisterProductResponse bossRegisterProduct(BossRegisterProductRequest bossRegisterProductRequest) {
        LogUtil.info("bossRegister() -> bossRegisterProductRequest: " + bossRegisterProductRequest);
        List<ProductTb> productExist = productRepository.findAll();
        if (!productExist.isEmpty()) {
            for (ProductTb product : productExist) {
                if (product.getCode().equalsIgnoreCase(bossRegisterProductRequest.getCode())) {
                    return new BossRegisterProductResponse(400, "Existe un producto con este código");
                } else if (product.getName().equalsIgnoreCase(bossRegisterProductRequest.getName())) {
                    return new BossRegisterProductResponse(400, "Existe un producto con este nombre");
                }
            }
        }

        ProductTb newProduct = new ProductTb();
        newProduct.setCode(bossRegisterProductRequest.getCode());
        newProduct.setName(bossRegisterProductRequest.getName());
        newProduct.setPrice(bossRegisterProductRequest.getPrice());
        newProduct.setCreateTime(new Date());
        newProduct.setUpdateTime(newProduct.getCreateTime());

        productRepository.save(newProduct);

        return new BossRegisterProductResponse(200, "Se registró el producto existosamente");
    }

    @Override
    public BossProductListResponse listBossProduct() {

        BossProductListResponse bossProductListResponse = new BossProductListResponse();

        List<BossProductDto> listProduct = bossDao.listResultBossProduct();
        if (listProduct.isEmpty()) {
            bossProductListResponse.setStatus(204);
            bossProductListResponse.setMessage("No existe ningún producto");
        } else {
            bossProductListResponse.setStatus(200);
            bossProductListResponse.setMessage("Se listan los productos");
        }
        bossProductListResponse.setBossProducts(listProduct);
        return bossProductListResponse;
    }

    @Override
    public BossOrderListResponse listBossOrder() {
        BossOrderListResponse bossOrderListResponse = new BossOrderListResponse();
        List<BossOrderDto> listBossOrder = bossDao.listResultBossOrder();
        if (listBossOrder.isEmpty()) {
            bossOrderListResponse.setStatus(204);
            bossOrderListResponse.setMessage("No existen pedidos registrados");
        } else {
            bossOrderListResponse.setStatus(200);
            bossOrderListResponse.setMessage("Se listan los pedidos registrados");
        }
        bossOrderListResponse.setBossOrders(listBossOrder);
        return bossOrderListResponse;
    }

    @Override
    public BossOrderProductListResponse listBossOrderProduct(Long idRecordOrder) {
        BossOrderProductListResponse bossOrderProductListResponse = new BossOrderProductListResponse();
        List<BossOrderProductDto> listBossOrderProduct = bossDao.listResultBossOrderProduct(idRecordOrder);
        LogUtil.info("listBossOrderProduct: " + listBossOrderProduct);
        if (listBossOrderProduct.isEmpty()) {
            bossOrderProductListResponse.setStatus(400);
            bossOrderProductListResponse.setMessage("No existe el pedido con el id " + idRecordOrder);
        } else {
            bossOrderProductListResponse.setStatus(200);
            bossOrderProductListResponse.setMessage("Se lista los productos del pedido");
        }
        bossOrderProductListResponse.setBossOrderProducts(listBossOrderProduct);
        return bossOrderProductListResponse;
    }

    @Override
    public BossAttendanceListResponse listBossHistoryAttendance() {
        BossAttendanceListResponse bossAttendanceListResponse = new BossAttendanceListResponse();
        List<HistoryAttendanceTb> listHistoryAttendance = historyAttendanceRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        if (listHistoryAttendance.isEmpty()) {
            bossAttendanceListResponse.setStatus(204);
            bossAttendanceListResponse.setMessage("No hay ningún registro de asistencia");
        } else {
            bossAttendanceListResponse.setStatus(200);
            bossAttendanceListResponse.setMessage("Se listan los registros de asistencia de los empleados");
        }
        bossAttendanceListResponse.setBossHistoryAttendances(listHistoryAttendance);
        return bossAttendanceListResponse;
    }

    @Override
    public BossAttendanceEmployeeListResponse listBossEmployeeHistoryAttendance(Long idAccount) {
        BossAttendanceEmployeeListResponse bossAttendanceEmployeeListResponse = new BossAttendanceEmployeeListResponse();
        List<HistoryAttendanceTb> listEmployeeHistoryAttendance = historyAttendanceRepository.findAllByIdAccount(idAccount, Sort.by("id").descending());
        if (listEmployeeHistoryAttendance.isEmpty()) {
            bossAttendanceEmployeeListResponse.setStatus(204);
            bossAttendanceEmployeeListResponse.setMessage("El empleado no tiene ninguna asistencia registrada");
        } else {
            bossAttendanceEmployeeListResponse.setStatus(200);
            bossAttendanceEmployeeListResponse.setMessage("Se lista el hisotorico de asistencias del empleado");
        }
        bossAttendanceEmployeeListResponse.setBossEmployeeHistoryAttendances(listEmployeeHistoryAttendance);
        return bossAttendanceEmployeeListResponse;
    }

    @Override
    public BossEditEmployeeResponse bossEditEmployee(BossEditEmployeeRequest bossEditEmployeeRequest) {
        Optional<PersonTb> personExist = personRepository.findById(bossEditEmployeeRequest.getId());
        if (personExist.isEmpty()) {
            return new BossEditEmployeeResponse(400, "No existe la persona con el id: " + bossEditEmployeeRequest.getId());
        }
        Optional<AccountTb> accountExist = accountRepository.findById(bossEditEmployeeRequest.getIdAccount());
        if (accountExist.isEmpty()) {
            return new BossEditEmployeeResponse(400, "No existe la cuenta con el id: " + bossEditEmployeeRequest.getIdAccount());
        }
        List<PersonTb> listPerson = personRepository.findAll();
        listPerson.remove(personExist.get());
        BaseResponse baseResponse = getResponse(listPerson, bossEditEmployeeRequest.getDni(),
                bossEditEmployeeRequest.getEmail(),
                bossEditEmployeeRequest.getCellphone(),
                bossEditEmployeeRequest.getName(),
                bossEditEmployeeRequest.getLastname(),
                bossEditEmployeeRequest.getMotherLastname());

        if (baseResponse.getStatus().equals(400)) {
            return new BossEditEmployeeResponse(baseResponse.getStatus(), baseResponse.getMessage());
        }

        if (!StringUtils.trimToEmpty(bossEditEmployeeRequest.getEmail()).isEmpty() &&
                !bossEditEmployeeRequest.getEmail().equals(personExist.get().getEmail())){
            sendPasswordEmail.sendPasswordEmail(bossEditEmployeeRequest.getEmail(), accountExist.get().getPassword());
        }

        PersonTb editPerson = personExist.get();
        editPerson.setName(StringUtils.trimToEmpty(bossEditEmployeeRequest.getName().toUpperCase()));
        editPerson.setLastname(StringUtils.trimToEmpty(bossEditEmployeeRequest.getLastname().toUpperCase()));
        editPerson.setMotherLastname(StringUtils.trimToEmpty(bossEditEmployeeRequest.getMotherLastname().toUpperCase()));
        editPerson.setDni(StringUtils.trimToEmpty(bossEditEmployeeRequest.getDni()));
        editPerson.setEmail(StringUtils.trimToEmpty(bossEditEmployeeRequest.getEmail()));
        editPerson.setCellphone(StringUtils.trimToEmpty(bossEditEmployeeRequest.getCellphone()));
        editPerson.setUpdateTime(new Date());
        personRepository.save(editPerson);

        return new BossEditEmployeeResponse(200, "Se editó la información de la persona");

    }

    @Override
    public BossEditAccountEmployeeResponse bossEditAccountEmployee(BossEditAccountEmployeeRequest bossEditAccountEmployeeRequest) {
        BossEditAccountEmployeeResponse bossEditAccountEmployeeResponse = new BossEditAccountEmployeeResponse();
        Optional<AccountTb> accountExist = accountRepository.findByIdAndStatusNot(bossEditAccountEmployeeRequest.getId(), 0);
        if (accountExist.isEmpty()) {
            return new BossEditAccountEmployeeResponse(400, "No existe la cuenta con el id: " + bossEditAccountEmployeeRequest.getId());
        }
        Optional<PersonTb> personExist = personRepository.findByIdAccount(accountExist.get().getId());
        if (personExist.isEmpty()) {
            return new BossEditAccountEmployeeResponse(400, "No existe la persona de la cuenta");
        } else {
            AccountTb account = accountExist.get();
            account.setPassword(bossEditAccountEmployeeRequest.getPassword());
            account.setUpdateTime(new Date());

            accountRepository.save(account);

            sendPasswordEmail.sendPasswordEmail(personExist.get().getEmail(),account.getPassword());

            return new BossEditAccountEmployeeResponse(200, "Se editó la cuenta correctamente");
        }
    }

    @Override
    public BossRegisterStockResponse bossRegisterStock(BossRegisterStockRequest bossRegisterStockRequest) {
        List<StockTb> listStock = stockRepository.findAll();
        for (StockTb stock : listStock) {
            if (!StringUtils.trimToEmpty(bossRegisterStockRequest.getName()).isEmpty() &&
                    StringUtils.trimToEmpty(bossRegisterStockRequest.getName()).equalsIgnoreCase(StringUtils.trimToEmpty(stock.getName()))) {
                return new BossRegisterStockResponse(400, "El nombre de este artículo ya se encuentra en uso");
            }
            if (StringUtils.trimToEmpty(bossRegisterStockRequest.getUnit()).isEmpty()) {
                return new BossRegisterStockResponse(400, "Ingrese la unidad que representa al artículo. Ejemplo: Kg,5Kg,3L,etc");
            }
            if (bossRegisterStockRequest.getPriceUnit() == 0) {
                return new BossRegisterStockResponse(400, "Ingrese un valor para el artículo");
            }
        }
        StockTb stockRegister = new StockTb();
        stockRegister.setName(StringUtils.trimToEmpty(bossRegisterStockRequest.getName()).toUpperCase());
        stockRegister.setUnit(StringUtils.trimToEmpty(bossRegisterStockRequest.getUnit()).toUpperCase());
        stockRegister.setPriceUnit(bossRegisterStockRequest.getPriceUnit());
        stockRegister.setAmount(0);

        stockRegister = stockRepository.save(stockRegister);

        HistoryStockTb historyStock = new HistoryStockTb();
        historyStock.setIdStock(stockRegister.getId());
        historyStock.setName(stockRegister.getName());
        historyStock.setUnit(stockRegister.getUnit());
        historyStock.setPriceUnit(stockRegister.getPriceUnit());
        historyStock.setAmount(stockRegister.getAmount());
        historyStock.setCreateTime(new Date());

        historyStockRepository.save(historyStock);

        stockRegister.setCreateTime(new Date());
        stockRegister.setUpdateTime(stockRegister.getCreateTime());

        stockRepository.save(stockRegister);

        return new BossRegisterStockResponse(200, "Se registró el artículo con éxito");
    }

    @Override
    public BossStockListResponse listBossStock() {
        BossStockListResponse bossStockListResponse = new BossStockListResponse();
        List<BossStockDto> listManagerStock = bossDao.listResultBossStock();
        if (listManagerStock.isEmpty()) {
            bossStockListResponse.setStatus(204);
            bossStockListResponse.setMessage("No hay artículos registrados");
        } else {
            bossStockListResponse.setStatus(200);
            bossStockListResponse.setMessage("Se listan los artículos");
        }
        bossStockListResponse.setBossStocks(listManagerStock);
        return bossStockListResponse;
    }

    @Override
    public BossRegisterStockAmountResponse bossRegisterStockAmount(BossRegisterStockAmountRequest bossRegisterStockAmountRequest) {
        BossRegisterStockAmountResponse bossRegisterStockAmountResponse = new BossRegisterStockAmountResponse();
        Optional<StockTb> stockExist = stockRepository.findById(bossRegisterStockAmountRequest.getId());
        if (stockExist.isEmpty()) {
            bossRegisterStockAmountResponse.setStatus(400);
            bossRegisterStockAmountResponse.setMessage("No existe el artículo con el id: " + bossRegisterStockAmountRequest.getId());
        } else {
            StockTb stock = stockExist.get();
            stock.setAmount(bossRegisterStockAmountRequest.getAmount());
            stock.setUpdateTime(new Date());

            HistoryStockTb historyStock = new HistoryStockTb();
            historyStock.setIdStock(bossRegisterStockAmountRequest.getId());
            historyStock.setName(stock.getName());
            historyStock.setUnit(stock.getUnit());
            historyStock.setPriceUnit(stock.getPriceUnit());
            historyStock.setAmount(bossRegisterStockAmountRequest.getAmount());
            historyStock.setCreateTime(new Date());

            historyStockRepository.save(historyStock);
            stockRepository.save(stock);

            bossRegisterStockAmountResponse.setStatus(200);
            bossRegisterStockAmountResponse.setMessage("Se registró la cantidad del artículo");
        }
        return bossRegisterStockAmountResponse;
    }

    @Override
    public BossEditStockResponse bossEditStock(BossEditStockRequest bossEditStockRequest) {
        Optional<StockTb> stockExist = stockRepository.findById(bossEditStockRequest.getId());
        if (stockExist.isEmpty()) {
            return new BossEditStockResponse(400, "No existe el artículo con este id: " + bossEditStockRequest.getId());
        } else {
            List<StockTb> listStock = stockRepository.findAll();
            listStock.remove(stockExist.get());
            for (StockTb stock : listStock) {
                LogUtil.info(stock.toString());
                if (!StringUtils.trimToEmpty(stock.getName()).isEmpty() && bossEditStockRequest.getName().equalsIgnoreCase(stock.getName())) {
                    return new BossEditStockResponse(400, "Este nombre de artículo ya se encuentra en uso");
                }
            }
            StockTb stock = stockExist.get();
            stock.setName(StringUtils.trimToEmpty(bossEditStockRequest.getName()).toUpperCase());
            stock.setUnit(StringUtils.trimToEmpty(bossEditStockRequest.getUnit()).toUpperCase());
            stock.setPriceUnit(bossEditStockRequest.getPriceUnit());
            stock.setUpdateTime(new Date());

            HistoryStockTb historyStock = new HistoryStockTb();
            historyStock.setIdStock(bossEditStockRequest.getId());
            historyStock.setName(StringUtils.trimToEmpty(bossEditStockRequest.getName()).toUpperCase());
            historyStock.setUnit(StringUtils.trimToEmpty(bossEditStockRequest.getUnit()).toUpperCase());
            historyStock.setPriceUnit(bossEditStockRequest.getPriceUnit());
            historyStock.setAmount(stock.getAmount());
            historyStock.setCreateTime(new Date());

            historyStockRepository.save(historyStock);
            stockRepository.save(stock);

            return new BossEditStockResponse(200, "Se editó la información del artículo");

        }
    }

    @Override
    public BossNoticeListResponse listBossNotice() {
        BossNoticeListResponse bossNoticeListResponse = new BossNoticeListResponse();
        List<BossNoticeDto> listNotice = bossDao.listResultBossNotice();
        if (listNotice.isEmpty()){
            bossNoticeListResponse.setStatus(204);
            bossNoticeListResponse.setMessage("No existe avisos registrados");
        } else {
            bossNoticeListResponse.setStatus(200);
            bossNoticeListResponse.setMessage("Se listan los avisos enviados");
        }
        bossNoticeListResponse.setBossNotices(listNotice);
        return bossNoticeListResponse;
    }

    private BaseResponse getResponse(List<PersonTb> listPerson, String dni, String email, String cellphone, String name, String lastname, String motherLastname) {
//        List<PersonTb> listPerson = personRepository.findAll();
        for (PersonTb person : listPerson) {
            if (!StringUtils.trimToEmpty(dni).isEmpty() && dni.equalsIgnoreCase(person.getDni())) {
                return new BaseResponse(400, "El número de Dni ingresado ya se encuentra en uso");
            }

            if (!StringUtils.trimToEmpty(email).isEmpty() && email.equalsIgnoreCase(person.getEmail())) {
                return new BaseResponse(400, "El email ingresado ya se encuentra en uso");
            }

            if (!StringUtils.trimToEmpty(cellphone).isEmpty() && cellphone.equalsIgnoreCase(person.getCellphone())) {
                return new BaseResponse(400, "El numero celular ya se ha registrado");
            }

            if (person.getName().equalsIgnoreCase(name) &&
                    person.getLastname().equalsIgnoreCase(lastname) &&
                    person.getMotherLastname().equalsIgnoreCase(motherLastname)) {
                return new BaseResponse(400, "Ya existe una persona con el mismo nombre y apellidos");
            }
        }

        return new BaseResponse(200, "Ok");
    }

    private PersonTb generatePerson(String name, String lastname, String motherLastname, String dni, String email, String cellphone) {

        PersonTb person = new PersonTb();
        person.setName(StringUtils.trimToEmpty(name.toUpperCase()));
        person.setLastname(StringUtils.trimToEmpty(lastname.toUpperCase()));
        person.setMotherLastname(StringUtils.trimToEmpty(motherLastname.toUpperCase()));
        person.setDni(StringUtils.trimToEmpty(dni));
        person.setEmail(StringUtils.trimToEmpty(email));
        person.setCellphone(StringUtils.trimToEmpty(cellphone));
        person.setCreateTime(new Date());
        person.setUpdateTime(person.getCreateTime());

        return person;
    }

    public AccountTb generateAccount(String name, String email, Integer idRole) {

        AccountTb newAccount = new AccountTb();
        String code = new CodeFactory().generateCodeAccount(name);
        newAccount.setCode(code);
        newAccount.setUsername(email);
        newAccount.setPassword(code);
        newAccount.setIdRole(idRole);
        newAccount.setEnable(false);
        newAccount.setStatus(1);
        newAccount.setCreateTime(new Date());
        newAccount.setUpdateTime(newAccount.getCreateTime());

        return newAccount;
    }

}
