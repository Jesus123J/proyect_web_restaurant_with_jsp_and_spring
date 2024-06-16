/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.data.dto;


import lombok.Getter;

@Getter

public class BossOrderProductDto {

    private Long id;
    private Long idProduct;
    private String productCode;
    private String nameProduct;
    private Double priceUnit;
    private Integer amountProduct;
    private Double priceProducts;


}