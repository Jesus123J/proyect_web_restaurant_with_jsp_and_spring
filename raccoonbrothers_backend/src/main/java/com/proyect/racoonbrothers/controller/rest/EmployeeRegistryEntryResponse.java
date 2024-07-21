package com.proyect.racoonbrothers.controller.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class EmployeeRegistryEntryResponse extends BaseResponse{
    Date dateEntry;

    public EmployeeRegistryEntryResponse() {

    }
}
