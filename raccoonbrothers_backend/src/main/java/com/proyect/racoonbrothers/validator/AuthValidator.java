package com.proyect.racoonbrothers.validator;

import com.proyect.racoonbrothers.exception.RacoonBrotherException;
import com.proyect.racoonbrothers.controller.rest.LoginRequest;

public interface AuthValidator {

    void validateLogin(LoginRequest loginRequest) throws RacoonBrotherException;

}
