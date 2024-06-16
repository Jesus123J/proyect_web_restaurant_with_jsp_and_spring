/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.data.entity;

import lombok.*;
import java.util.Date;

@Getter
@Setter

public class StockTb {

    private Integer id;

    private String name;

    private String unit;

    private Double priceUnit;

    private Integer amount;

    private Date createTime;

    private Date updateTime;

}