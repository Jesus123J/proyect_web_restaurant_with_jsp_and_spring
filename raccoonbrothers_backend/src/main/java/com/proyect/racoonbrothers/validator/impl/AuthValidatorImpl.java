package com.proyect.racoonbrothers.validator.impl;

import com.proyect.racoonbrothers.exception.ApiBadRequest;
import com.proyect.racoonbrothers.exception.ApiUnauthorized;
import com.proyect.racoonbrothers.exception.ExceptionDetails;
import com.proyect.racoonbrothers.exception.RacoonBrotherException;
import com.proyect.racoonbrothers.controller.rest.LoginRequest;
import com.proyect.racoonbrothers.validator.AuthValidator;
import org.springframework.stereotype.Service;


import java.util.Objects;

@Service
public class AuthValidatorImpl implements AuthValidator {
    @Override
        public void validateLogin(LoginRequest loginRequest) throws RacoonBrotherException {
        System.out.println("Se esta ingresando al metodo");
        if (Objects.isNull(loginRequest) ||
                loginRequest.getUsername().isBlank() ||
                loginRequest.getPassword().isBlank()) {

            System.out.println("Se esta ingresando al metodo 2");
            messageLogin();
        }

        if (loginRequest.getUsername().length() <= 4) {

            messageLogin("username debe contener más de 4 carácteres");
        }

        if (loginRequest.getPassword().length() < 8) {
            messageLogin("password debe contener como mínimo 8 carácteres");
        }
    }

//    @Override
//    public void validateRegister(MultiValueMap<String, String> paramMap){
//        if (Objects.isNull(paramMap) ||
//                paramMap.getFirst("username").isBlank() ||
//                paramMap.getFirst("password").isBlank() ||
//                paramMap.getFirst("name").isBlank() ||
//                paramMap.getFirst("lastname").isBlank() ||
//                paramMap.getFirst("motherLastname").isBlank() ||
//                paramMap.getFirst("email").isBlank()) {
//            messageRegister("datos ingresados inválidos");
//        }
//
//        if (paramMap.getFirst("username").length() <= 4) {
//            messageRegister("username debe contener más de 4 carácteres");
//        }
//
//        if (paramMap.getFirst("password").length() < 8) {
//            messageRegister("password debe contener como mínimo 8 carácteres");
//        }
//
//        if (paramMap.getFirst("name").length() < 2) {
//            messageRegister("nombre debe contener más de 1 carácter");
//        }
//
//        if (paramMap.getFirst("lastname").length() < 2) {
//            messageRegister("apellido debe contener más de 1 carácter");
//        }
//
//        if (paramMap.getFirst("motherLastname").length() < 2) {
//            messageRegister("apellido materno debe contener más de 1 carácter");
//        }
//
//        if (!isValidEmail(paramMap.getFirst("email"))) {
//            messageRegister("email inválido");
//        }
//
//    }

//    private boolean isValidEmail(String email) {
//        return email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$");
//    }

    private void messageLogin(String message) throws ApiUnauthorized {
        throw new ApiUnauthorized(new ExceptionDetails(message));
    }
    private void messageLogin() throws ApiBadRequest {
        throw new ApiBadRequest(new ExceptionDetails("Ingrese un username y contraseña"));
    }

}
