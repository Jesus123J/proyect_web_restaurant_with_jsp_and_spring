/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.data.dto;

import lombok.Getter;

@Getter

public class BossOrderDto {

    private Long id;
    private String orderCode;
    private String clientName;
    private Double orderPrice;
    private Long idAccount;
    private String fullName;
    private String createTime;
    private String updateTime;


}