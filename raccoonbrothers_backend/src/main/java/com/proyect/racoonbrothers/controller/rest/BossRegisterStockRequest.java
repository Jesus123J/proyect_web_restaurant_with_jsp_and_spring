package com.proyect.racoonbrothers.controller.rest;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BossRegisterStockRequest {

    private String name;
    private String unit;
    private Double priceUnit;

}
