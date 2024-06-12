package com.proyect.racoonbrothers.validator;

import com.proyect.racoonbrothers.data.dto.AccountDto;
import com.proyect.racoonbrothers.exception.RacoonBrotherException;

public interface TokenValidator {
    AccountDto verification(String token, String roleType) throws RacoonBrotherException;
}
