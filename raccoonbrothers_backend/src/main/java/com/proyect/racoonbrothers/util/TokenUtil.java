package com.proyect.racoonbrothers.util;

import com.proyect.racoonbrothers.data.dto.AccountDto;
import com.proyect.racoonbrothers.exception.ApiBadRequest;
import com.proyect.racoonbrothers.exception.ExceptionDetails;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class TokenUtil {

    public static String generateToken(Object object){
        String subject = GsonUtil.serialize(object);
       return Base64.getEncoder().encodeToString(subject.getBytes(StandardCharsets.UTF_8));
    }

    public static AccountDto deserializeToken(String token) throws ApiBadRequest {
        try {
            return GsonUtil.toObject(token, AccountDto.class);
        }catch (Exception e){
            throw new ApiBadRequest(new ExceptionDetails("El token no tiene el codificado correcto"));
        }
    }

}
