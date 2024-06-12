package com.proyect.racoonbrothers.data.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@ToString
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
