package com.proyect.racoonbrothers.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDetails {

    private Integer status = 500;
    private String message = "Ha ocurrido un error inesperado, por favor contacte al administrador";

    public ExceptionDetails(String messageUser){
        this.message = messageUser;
    }

    public ExceptionDetails(String messageUser,Integer status){
        this.message = messageUser;
        this.status = status;
    }

}
