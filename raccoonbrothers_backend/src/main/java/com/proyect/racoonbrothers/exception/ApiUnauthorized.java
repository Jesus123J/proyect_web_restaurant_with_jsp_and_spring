package com.proyect.racoonbrothers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnauthorized extends RacoonBrotherException {

    public ApiUnauthorized (ExceptionDetails details){
        super(details);
    }

}
