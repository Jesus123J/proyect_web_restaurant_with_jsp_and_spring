/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.data.dto;

import lombok.Getter;

@Getter

public class BossNoticeDto {

    private Long idRecordNotice;
    private Long idAccount;
    private Long idPerson;
    private String description;
    private Integer readBoss;
    private String name;
    private String lastname;
    private String motherLastname;
    private String createTime;
    private String updateTime;

}