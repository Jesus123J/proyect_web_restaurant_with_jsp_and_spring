/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.data.rest;

import com.utp.management_web_application.data.dto.ManagerOrderProductDto;
import lombok.Getter;

import java.util.List;

@Getter
public class ManagerRegisterOrderRequest {

    private String clientName;
    private Double orderPrice;
    private List<ManagerOrderProductDto> orderProducts;
}
