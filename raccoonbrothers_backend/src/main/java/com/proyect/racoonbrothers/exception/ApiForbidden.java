package com.proyect.racoonbrothers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ApiForbidden extends RacoonBrotherException {

    public ApiForbidden(ExceptionDetails details) {
        super(details);
    }
}
