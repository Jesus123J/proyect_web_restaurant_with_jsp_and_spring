package com.proyect.racoonbrothers.controller.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoosRegisterEmployeeResponse extends BaseResponse{
    public BoosRegisterEmployeeResponse(Integer status, String message) {
        super(status, message);
    }
}
