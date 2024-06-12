package com.proyect.racoonbrothers.validator.impl;

import com.proyect.racoonbrothers.data.dto.AccountDto;
import com.proyect.racoonbrothers.data.entity.ERole;
import com.proyect.racoonbrothers.exception.*;
import com.proyect.racoonbrothers.util.LogUtil;
import com.proyect.racoonbrothers.util.TokenUtil;
import com.proyect.racoonbrothers.validator.TokenValidator;
import org.springframework.stereotype.Service;

@Service
public class TokenValidatorImpl implements TokenValidator {
    @Override
    public AccountDto verification(String headerToken, String roleType) throws RacoonBrotherException {

        if (headerToken == null){
            LogUtil.info("verification 1: -> " + null);
            throw new ApiUnauthorized(new ExceptionDetails("Se requiere el token de autenticación"));
        }else if (!headerToken.contains("Bearer")) {
            LogUtil.info("verification 2: -> " + headerToken);
            throw new ApiBadRequest(new ExceptionDetails("Falta el tipo de token 'Bearer' en el header"));
        }

        String tokenSerialize = headerToken.replace("Bearer", "").replace(" ", "");
        if (tokenSerialize.equalsIgnoreCase("null")) {
            LogUtil.info("verification 3-> " + tokenSerialize);
            throw new ApiUnauthorized(new ExceptionDetails("El token tiene valor null"));
        }

        if (tokenSerialize.isEmpty()) {
            LogUtil.info("verification 4: -> " + tokenSerialize);
            throw new ApiBadRequest(new ExceptionDetails("El token está vacío"));
        }

        AccountDto account = TokenUtil.deserializeToken(tokenSerialize);
        if (!account.getRoleType().equalsIgnoreCase(ERole.SUPERADMIN.name())) {
            if (!account.getRoleType().equalsIgnoreCase(roleType)) {
                throw new ApiForbidden(new ExceptionDetails("No tiene permiso para acceder a este servicio"));
            }
        }

        return account;
    }

}
