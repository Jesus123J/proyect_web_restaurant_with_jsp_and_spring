package com.proyect.racoonbrothers.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BossOrderDto {

    private Long id;
    private String orderCode;
    private String clientName;
    private Double orderPrice;
    private Long idAccount;
    private String fullName;
    private String createTime;
    private String updateTime; // Esta columna no está en la consulta, puede ser null
}
