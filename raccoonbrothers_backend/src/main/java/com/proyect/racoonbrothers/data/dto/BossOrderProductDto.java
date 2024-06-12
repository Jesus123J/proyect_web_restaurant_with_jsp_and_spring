package com.proyect.racoonbrothers.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class BossOrderProductDto {

    private Long id;
    private Long idProduct;
    private String productCode;
    private String nameProduct;
    private Double priceUnit;
    private Integer amountProduct;
    private Double priceProducts;


}
