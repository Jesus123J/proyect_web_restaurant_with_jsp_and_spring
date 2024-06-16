/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.data.rest;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BossEditEmployeeRequest {

    private Long id;
    private Long idAccount;
    private String name;
    private String lastname;
    private String motherLastname;
    private String email;
    private String cellphone;
    private String dni;

}