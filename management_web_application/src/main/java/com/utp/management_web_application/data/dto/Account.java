/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.data.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    
    @NotNull(message = "El nombre de usuario no puede estar vacío")
    @Size(min = 6, message = "El nombre de usuario debe tener al menos {min} caracteres")
    private String username;

    @NotNull(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La contraseña debe tener al menos {min} caracteres")
    private String password;
}
