package com.proyect.racoonbrothers.controller.rest;

import com.proyect.racoonbrothers.data.dto.ManagerOrderProductDto;
import lombok.Getter;

import java.util.List;

@Getter
public class ManagerRegisterOrderRequest {

    private String clientName;
    private Double orderPrice;
    private List<ManagerOrderProductDto> orderProducts;
}
