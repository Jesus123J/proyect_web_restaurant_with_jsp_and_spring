package com.proyect.racoonbrothers.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ManagerEmployeeDto {

    private Long id;
    private String fullName;
    private String email;
    private String cellphone;
    private String dni;
    private String accountType;

}
