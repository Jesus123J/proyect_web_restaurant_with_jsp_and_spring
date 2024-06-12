package com.proyect.racoonbrothers.controller.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BossRegisterProductResponse extends BaseResponse {

    public BossRegisterProductResponse(Integer status, String message) {
        super(status, message);
    }
}
