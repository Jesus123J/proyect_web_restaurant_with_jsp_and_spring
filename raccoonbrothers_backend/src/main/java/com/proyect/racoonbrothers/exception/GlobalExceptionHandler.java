package com.proyect.racoonbrothers.exception;

import com.proyect.racoonbrothers.util.LogUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {RacoonBrotherException.class})
    public ResponseEntity<?> handleRacoonBrotherException(WebRequest webRequest, RacoonBrotherException exception) {
        ExceptionDetails exceptionDetails = exception.getDetails();
        ResponseStatus responseStatus = exception.getClass().getAnnotation(ResponseStatus.class);
        exceptionDetails.setStatus(responseStatus.value().value());
        return ResponseEntity.ok(exceptionDetails);
    }

    @ExceptionHandler(value = {Exception.class,RuntimeException.class})
    public ResponseEntity<?> handleException(WebRequest webRequest, Exception exception) {
        ExceptionDetails exceptionDetails = new ExceptionDetails();
        exceptionDetails.setStatus(500);
        if (exception.getCause() != null){
            LogUtil.error("handleException() -> "+ exception.getMessage());
            exceptionDetails.setMessage(exception.getCause().toString());
        } else {
            LogUtil.error("handleException() -> "+ exception.getMessage());
            exceptionDetails.setMessage(exception.getMessage());
        }
        return ResponseEntity.ok(exceptionDetails);
    }


}
