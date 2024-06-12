package com.proyect.racoonbrothers.data.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ManagerOrderProductDto {

    private String productCode;
    private Integer amount;
    private Double priceProducts;

}
