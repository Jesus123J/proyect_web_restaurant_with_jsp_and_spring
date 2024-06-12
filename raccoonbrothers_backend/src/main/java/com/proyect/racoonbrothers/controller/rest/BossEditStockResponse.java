package com.proyect.racoonbrothers.controller.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BossEditStockResponse extends BaseResponse{
    public BossEditStockResponse(Integer status, String message) {
        super(status, message);
    }
}
