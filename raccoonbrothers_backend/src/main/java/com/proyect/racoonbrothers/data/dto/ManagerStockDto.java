package com.proyect.racoonbrothers.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ManagerStockDto {

    private Long id;
    private String name;
    private String unit;
    private Double priceUnit;
    private Integer amount;

}
