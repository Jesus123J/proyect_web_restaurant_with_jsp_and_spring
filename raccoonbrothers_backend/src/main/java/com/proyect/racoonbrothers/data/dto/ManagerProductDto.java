package com.proyect.racoonbrothers.data.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ManagerProductDto {

    private Integer id;
    private String code;
    private String name;
    private Double price;

}
