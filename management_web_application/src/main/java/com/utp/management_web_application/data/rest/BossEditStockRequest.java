/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.data.rest;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BossEditStockRequest {

    private Integer id;
    private String name;
    private String    unit;
    private Double priceUnit;

}