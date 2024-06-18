/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.data.dto;

import lombok.*;

@Data
public class AccountDto {

    private Long idAccount;
    private Long idPerson;
    private Integer status;
    private String username;
    private String name;
    private String lastname;
    private String motherLastname;
    private Integer idRole;
    private String roleType;
}
