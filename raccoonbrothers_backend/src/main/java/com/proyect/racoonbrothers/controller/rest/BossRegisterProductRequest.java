package com.proyect.racoonbrothers.controller.rest;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BossRegisterProductRequest {

    private String name;
    private String code;
    private Double price;

}
