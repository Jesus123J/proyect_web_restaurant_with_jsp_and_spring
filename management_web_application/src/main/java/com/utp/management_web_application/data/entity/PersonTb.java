/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.data.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter

public class PersonTb {

   
    private Long id;

    private String name;

    private String lastname;

    private String motherLastname;

    private String email;

    private String cellphone;

    private String dni;

    private Long idAccount;

    private Date createTime;

    private Date updateTime;

}
