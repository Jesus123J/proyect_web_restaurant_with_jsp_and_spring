package com.proyect.racoonbrothers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApiBadRequest extends RacoonBrotherException{

    public ApiBadRequest(ExceptionDetails details) {
        super(details);
    }
}
