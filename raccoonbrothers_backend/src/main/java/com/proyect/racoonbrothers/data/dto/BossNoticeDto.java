package com.proyect.racoonbrothers.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
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
