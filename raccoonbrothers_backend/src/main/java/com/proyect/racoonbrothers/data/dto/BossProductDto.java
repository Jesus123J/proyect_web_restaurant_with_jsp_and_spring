package com.proyect.racoonbrothers.data.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BossProductDto {

    private Integer id;
    private String productCode;
    private String productName;
    private Double productPrice;

}
