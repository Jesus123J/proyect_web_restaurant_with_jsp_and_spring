package com.proyect.racoonbrothers.service.impl;

import com.proyect.racoonbrothers.controller.rest.*;
import com.proyect.racoonbrothers.data.dao.ManagerDao;
import com.proyect.racoonbrothers.data.dto.*;
import com.proyect.racoonbrothers.data.entity.StockTb;
import com.proyect.racoonbrothers.service.CodeFactory;
import com.proyect.racoonbrothers.service.ManagerDataProvider;
import com.proyect.racoonbrothers.data.entity.OrderProductTb;
import com.proyect.racoonbrothers.data.entity.RecordOrderTb;
import com.proyect.racoonbrothers.repository.OrderProductRepository;
import com.proyect.racoonbrothers.repository.RecordOrderRepository;
import com.proyect.racoonbrothers.service.ManagerService;
import com.proyect.racoonbrothers.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerDao managerDao;
    @Autowired
    RecordOrderRepository recordOrderRepository;
    @Autowired
    OrderProductRepository orderProductRepository;

    @Override
    public ManagerProductListResponse listManagerProduct() {
        ManagerProductListResponse managerProductListResponse = new ManagerProductListResponse();

        List<ManagerProductDto> listProduct = new ManagerDataProvider(managerDao).listResultManagerProduct();
        if (listProduct.isEmpty()) {
            managerProductListResponse.setStatus(204);
            managerProductListResponse.setMessage("No existe ningún producto");
        } else {
            managerProductListResponse.setStatus(200);
            managerProductListResponse.setMessage("Se listan los productos");
        }
        managerProductListResponse.setManagerProducts(listProduct);
        return managerProductListResponse;
    }

    @Override
    public ManagerEmployeeListResponse listManagerEmployee() {
        ManagerEmployeeListResponse managerEmployeeListResponse = new ManagerEmployeeListResponse();
        List<ManagerEmployeeDto> listEmployee = managerDao.listResultManagerEmployee();
        if (listEmployee.isEmpty()) {
            managerEmployeeListResponse.setStatus(204);
            managerEmployeeListResponse.setMessage("No existe ningún producto");
        } else {
            managerEmployeeListResponse.setStatus(200);
            managerEmployeeListResponse.setMessage("Se listan los productos");
        }
        managerEmployeeListResponse.setManagerEmployees(listEmployee);

        return managerEmployeeListResponse;
    }

    @Override
    public ManagerRegisterOrderResponse managerRegisterOrder(AccountDto token, ManagerRegisterOrderRequest managerRegisterOrderRequest) {
        ManagerRegisterOrderResponse managerRegisterOrderResponse = new ManagerRegisterOrderResponse();

        List<ManagerProductDto> listProduct = new ManagerDataProvider(managerDao).listResultManagerProduct();

        for (ManagerOrderProductDto orderProduct : managerRegisterOrderRequest.getOrderProducts()) {
            boolean codeExist = false;
            for (ManagerProductDto managerProduct : listProduct) {
//                Verifica si los códigos de los productos que recibo existen
                if (orderProduct.getProductCode().equalsIgnoreCase(managerProduct.getCode())) {
                    codeExist = true;
                    break;
                }
            }
            if (!codeExist) {
                managerRegisterOrderResponse.setStatus(400);
                managerRegisterOrderResponse.setMessage("No existe el código del producto ingresado: " + orderProduct.getProductCode());
                return managerRegisterOrderResponse;
            }
        }

        Optional<RecordOrderTb> lastRecordOrder = recordOrderRepository.findFirstByOrderByIdDesc();
        String lastOrderCode = CodeFactory.PREFIX_NAME.concat("000000000");
        if (lastRecordOrder.isPresent()) {
            lastOrderCode = lastRecordOrder.get().getOrderCode();
        }
        String orderCode = new CodeFactory().generateOrderCode(lastOrderCode);

        RecordOrderTb registryOrder = new RecordOrderTb();
        registryOrder.setOrderCode(orderCode);
        registryOrder.setClientName(managerRegisterOrderRequest.getClientName());
        registryOrder.setIdAccount(token.getIdAccount());
        registryOrder.setOrderPrice(managerRegisterOrderRequest.getOrderPrice());

        registryOrder = recordOrderRepository.save(registryOrder);

        LogUtil.info("managerRegisterOrder() -> CÓDIGO DEL PEDIDO: " + orderCode);

        for (ManagerOrderProductDto orderProduct : managerRegisterOrderRequest.getOrderProducts()) {
            OrderProductTb registryOrderProduct = getOrderProductTb(orderProduct, registryOrder);
            orderProductRepository.save(registryOrderProduct);
        }

        registryOrder.setCreateTime(new Date());
        recordOrderRepository.save(registryOrder);

        managerRegisterOrderResponse.setStatus(200);
        managerRegisterOrderResponse.setMessage("Se registró el pedido");
        return managerRegisterOrderResponse;
    }

    @Override
    public ManagerStockListResponse listManagerStock() {
        ManagerStockListResponse managerStockListResponse = new ManagerStockListResponse();
        List<ManagerStockDto> listManagerStock = managerDao.listResultManagerStock();
        if (listManagerStock.isEmpty()){
            managerStockListResponse.setStatus(204);
            managerStockListResponse.setMessage("No hay insumos registrados");
        } else {
            managerStockListResponse.setStatus(200);
            managerStockListResponse.setMessage("Se listan los insumos");
        }
        managerStockListResponse.setManagerStocks(listManagerStock);
        return managerStockListResponse;
    }

    private OrderProductTb getOrderProductTb(ManagerOrderProductDto orderProduct, RecordOrderTb registryOrder) {
        OrderProductTb registryOrderProduct = new OrderProductTb();
        registryOrderProduct.setCreateTime(new Date());
        registryOrderProduct.setUpdateTime(registryOrderProduct.getCreateTime());
        registryOrderProduct.setIdRecordOrders(registryOrder.getId());
        registryOrderProduct.setProductCode(orderProduct.getProductCode());
        registryOrderProduct.setAmountProduct(orderProduct.getAmount());
        registryOrderProduct.setPriceProducts(orderProduct.getPriceProducts());
        return registryOrderProduct;
    }
}
