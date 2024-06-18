package com.proyect.racoonbrothers.controller;

import com.proyect.racoonbrothers.data.dto.AccountDto;
import com.proyect.racoonbrothers.data.entity.ERole;
import com.proyect.racoonbrothers.exception.RacoonBrotherException;
import com.proyect.racoonbrothers.controller.rest.ManagerRegisterOrderRequest;
import com.proyect.racoonbrothers.service.ManagerService;
import com.proyect.racoonbrothers.validator.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/manager")
public class ManagerController {

    @Autowired
    ManagerService managerService;
    @Autowired
    TokenValidator tokenValidator;

    @GetMapping(value = "/dataManager", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> dataCompletMamager(@RequestHeader HttpHeaders headers) throws RacoonBrotherException {
        System.out.println("Entrando a api dataManager");
        System.out.println(headers.getFirst(HttpHeaders.AUTHORIZATION));
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION) , ERole.GERENTE.name());
        System.out.println("Entrando a api pasando");
        return ResponseEntity.ok(token);
    }
//    Lista los productos registrados
    @GetMapping(value = "/product/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listManagerProduct(@RequestHeader HttpHeaders headers) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION) , ERole.GERENTE.name());
        return ResponseEntity.ok(managerService.listManagerProduct());
    }

//    Lista de los empleados
    @GetMapping(value = "/employee/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listManagerEmployee(@RequestHeader HttpHeaders headers) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION) , ERole.GERENTE.name());
        return ResponseEntity.ok(managerService.listManagerEmployee());
    }

//    Registrar un pedido
    @PostMapping(value = "/order/register",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> managerRegisterOrder(@RequestBody ManagerRegisterOrderRequest managerRegisterOrderRequest,
                                                  @RequestHeader HttpHeaders headers) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION) , ERole.GERENTE.name());
        return ResponseEntity.ok(managerService.managerRegisterOrder(token,managerRegisterOrderRequest));
    }

//    Lista de los articulos registrados
    @GetMapping(value = "/stock/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listManagerStock(@RequestHeader HttpHeaders headers) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION) , ERole.GERENTE.name());
        return ResponseEntity.ok(managerService.listManagerStock());
    }




}
