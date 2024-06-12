package com.proyect.racoonbrothers.controller.rest;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BossEditEmployeeRequest {

    private Long id;
    private Long idAccount;
    private String name;
    private String lastname;
    private String motherLastname;
    private String email;
    private String cellphone;
    private String dni;

}
