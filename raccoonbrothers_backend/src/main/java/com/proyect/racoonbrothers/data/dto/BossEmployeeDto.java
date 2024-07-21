package com.proyect.racoonbrothers.data.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BossEmployeeDto {

    private Long id;
    private Long idAccount;
    private String fullName;
    private String email;
    private String cellphone;
    private String dni;
    private String accountType;

}
