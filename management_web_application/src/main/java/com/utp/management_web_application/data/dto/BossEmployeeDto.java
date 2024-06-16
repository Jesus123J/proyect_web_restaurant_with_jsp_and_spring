/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.data.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BossEmployeeDto {

    private Long id;
    private String fullName;
    private String email;
    private String cellphone;
    private String dni;
    private String accountType;

}