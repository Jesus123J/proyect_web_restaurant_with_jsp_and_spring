package com.proyect.racoonbrothers.controller;

import com.proyect.racoonbrothers.controller.rest.*;
import com.proyect.racoonbrothers.data.dto.AccountDto;
import com.proyect.racoonbrothers.data.entity.ERole;
import com.proyect.racoonbrothers.exception.RacoonBrotherException;
import com.proyect.racoonbrothers.service.BossService;
import com.proyect.racoonbrothers.validator.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/boss")
public class BossController {

    @Autowired
    BossService bossService;
    @Autowired
    TokenValidator tokenValidator;

    @PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> test(@RequestBody TestRequest testRequest) {

//        String date = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
//        System.out.println("date->" + date);

        return new ResponseEntity<>(testRequest.getMessage(), HttpStatus.valueOf(200));
    }

    //    Registrar un nuevo empleado
    @PostMapping(value = "/employee/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> bossRegisterEmployee(@RequestHeader HttpHeaders headers,
                                                  @RequestBody BossRegisterEmployeeRequest bossRegisterEmployeeRequest) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION), ERole.JEFE.name());
        return ResponseEntity.ok(bossService.bossRegisterEmployee(bossRegisterEmployeeRequest));
    }

    //    Editar la información de un empleado
    @PostMapping(value = "/employee/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> bossEditEmployee(@RequestHeader HttpHeaders headers,
                                              @RequestBody BossEditEmployeeRequest bossEditEmployeeRequest) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION), ERole.JEFE.name());
        return ResponseEntity.ok(bossService.bossEditEmployee(bossEditEmployeeRequest));
    }

    //    Editar la cuenta de un empleado
    @PostMapping(value = "/employee/account/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> bossEditAccountEmployee(@RequestHeader HttpHeaders headers,
                                                     @RequestBody BossEditAccountEmployeeRequest bossEditAccountEmployeeRequest) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION), ERole.JEFE.name());
        return ResponseEntity.ok(bossService.bossEditAccountEmployee(bossEditAccountEmployeeRequest));
    }

    //    Lista de los empleados
    @GetMapping(value = "/employee/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listBossEmployee(@RequestHeader HttpHeaders headers) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION), ERole.JEFE.name());
        return ResponseEntity.ok(bossService.listBossEmployee());
    }

    //    Registrar productos
    @PostMapping(value = "/product/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> bossRegisterProduct(@RequestBody BossRegisterProductRequest bossRegisterProductRequest,
                                                 @RequestHeader HttpHeaders headers) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION), ERole.JEFE.name());
        return ResponseEntity.ok(bossService.bossRegisterProduct(bossRegisterProductRequest));

    }

    //    Lista de los productos registrados
    @GetMapping(value = "/product/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listBossProduct(@RequestHeader HttpHeaders headers) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION), ERole.JEFE.name());
        return ResponseEntity.ok(bossService.listBossProduct());
    }

    //    Lista de los pedidos registrados
    @GetMapping(value = "/order/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listBoosOrder(@RequestHeader HttpHeaders headers
            /*@RequestParam(name = "orderCode") String orderCode*/) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION), ERole.JEFE.name());
        return ResponseEntity.ok(bossService.listBossOrder());
    }

    //    Muestra información del pedido
    @GetMapping(value = "/order/product/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listBossOrderProduct(@RequestHeader HttpHeaders headers,
                                                  @RequestParam(name = "idRecordOrder") Long idRecordOrder) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION), ERole.JEFE.name());
        return ResponseEntity.ok(bossService.listBossOrderProduct(idRecordOrder));
    }

    //    Lista de asistencia de los empleados
    @GetMapping(value = "/attendance/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listBossAttendance(@RequestHeader HttpHeaders headers) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION), ERole.JEFE.name());
        return ResponseEntity.ok(bossService.listBossHistoryAttendance());
    }

    //    Lista de asistencia de un empleado
    @GetMapping(value = "/attendance/employee/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listBossEmployeeAttendance(@RequestHeader HttpHeaders headers,
                                                        @RequestParam(name = "idAccount") Long idAccount) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION), ERole.JEFE.name());
        return ResponseEntity.ok(bossService.listBossEmployeeHistoryAttendance(idAccount));
    }

    //    Registro de los artículos
    @PostMapping(value = "/stock/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> bossRegisterStock(@RequestBody BossRegisterStockRequest bossRegisterStockRequest,
                                               @RequestHeader HttpHeaders headers) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION), ERole.JEFE.name());
        return ResponseEntity.ok(bossService.bossRegisterStock(bossRegisterStockRequest));
    }

    //    Registro de cantidad de artículos
    @PostMapping(value = "/stock/amount/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> bossRegisterStockAmount(@RequestBody BossRegisterStockAmountRequest bossRegisterStockAmountRequest,
                                                     @RequestHeader HttpHeaders headers) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION), ERole.JEFE.name());
        return ResponseEntity.ok(bossService.bossRegisterStockAmount(bossRegisterStockAmountRequest));
    }

    //    Editar la información del artículo
    @PostMapping(value = "/stock/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> bossEditStock(@RequestBody BossEditStockRequest bossEditStockRequest,
                                           @RequestHeader HttpHeaders headers) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION), ERole.JEFE.name());
        return ResponseEntity.ok(bossService.bossEditStock(bossEditStockRequest));
    }

    //    Listar los artículos
    @GetMapping(value = "/stock/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listBossStock(@RequestHeader HttpHeaders headers) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION), ERole.JEFE.name());
        return ResponseEntity.ok(bossService.listBossStock());
    }

    //    Recibir los avisos de los empleados
    @GetMapping(value = "/notice/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listBossNotice(@RequestHeader HttpHeaders headers) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION), ERole.JEFE.name());
        return ResponseEntity.ok(bossService.listBossNotice());
    }


}
