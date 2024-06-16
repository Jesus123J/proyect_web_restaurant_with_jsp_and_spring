/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.data.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter

public class RecordOrderTb {

  
    private Long id;

  
    private String orderCode;

    private String clientName;

    private Long idAccount;

    private Double orderPrice;

    private Date createTime;

}