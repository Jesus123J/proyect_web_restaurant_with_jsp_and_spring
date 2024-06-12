package com.proyect.racoonbrothers.controller;

import com.proyect.racoonbrothers.data.dto.AccountDto;
import com.proyect.racoonbrothers.data.entity.ERole;
import com.proyect.racoonbrothers.exception.RacoonBrotherException;
import com.proyect.racoonbrothers.service.EmployeeService;
import com.proyect.racoonbrothers.util.DateUtil;
import com.proyect.racoonbrothers.util.LogUtil;
import com.proyect.racoonbrothers.validator.TokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    TokenValidator tokenValidator;

    @GetMapping(value = "/hola")
    public String test() throws ParseException {

        Date date = new Date();
        LogUtil.info("" + date);
        LogUtil.info(date.getTime() + "");
        LogUtil.info(DateUtil.getDateTimeStamp());
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2024-05-08 02:00:31");
        LogUtil.info(date1.getTime() + "");
        LogUtil.info(date.compareTo(new Date(1714599583000L)) + "");

        return "Hola empleado";
    }

    //    Registro de entrada
    @PostMapping(value = "/register-entry", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> employeeRegistryEntry(@RequestHeader HttpHeaders headers) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION), ERole.EMPLEADO.name());
        return ResponseEntity.ok(employeeService.employeeRegistryEntry(token.getIdAccount()));
    }

    //    Registro de salida
    @PostMapping(value = "/register-departure", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> employeeRegistryDeparture(@RequestHeader HttpHeaders headers) throws RacoonBrotherException {
        AccountDto token = tokenValidator.verification(headers.getFirst(HttpHeaders.AUTHORIZATION), ERole.EMPLEADO.name());
        return ResponseEntity.ok(employeeService.employeeRegistryDeparture(token.getIdAccount()));
    }


}
