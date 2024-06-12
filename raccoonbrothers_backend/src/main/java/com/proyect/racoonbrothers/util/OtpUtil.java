package com.proyect.racoonbrothers.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OtpUtil {

//    Generación de código de 6 dígitos
    public String generateOtp() {
        Random random = new Random();
//        Crea un número aleatorio desde 0 hasta 999999
        String output = Integer.toString(random.nextInt(999999));
//        Agrega un número en la parte inicial del output en caso la cantidad de dígitos sea menor a 6
        while (output.length() < 6) {
            output = random.nextInt(9) + output;
        }
        return output;
    }

}
