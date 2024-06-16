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

public class RecordNoticeTb {

  
    private Long id;

    private Long idAccount;

    private Long idPerson;

    private String description;

    private Integer readBoss;

 
    private Date createTime;

    private Date updateTime;

}