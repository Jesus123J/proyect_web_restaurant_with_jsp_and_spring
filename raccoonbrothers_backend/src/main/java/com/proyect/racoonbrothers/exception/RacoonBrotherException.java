package com.proyect.racoonbrothers.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RacoonBrotherException extends Exception{

    private ExceptionDetails details;

//    public RacoonBrotherException(ExceptionDetails details, String exceptionMessage) {
//        super(exceptionMessage);
//        this.details = details;
//    }
}
