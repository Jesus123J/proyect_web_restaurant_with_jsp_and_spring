/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.data.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter

public class OtpTb {

    private Long id;

    private Long idAccount;

  
    private String otp;

    private Date createTime;

    private Date expirationTime;

}
