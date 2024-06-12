package com.proyect.racoonbrothers.service;

import lombok.AllArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

public class CodeFactory {

    public static final String PREFIX_NAME = "RBRO";

    public String generateCodeAccount(String name) {
//        Separa el nombre completo por los espacios y los guarda en un array
        String[] names = name.toUpperCase().split(" ");

        return Arrays.stream(names)
//                Obtiene la primera letra de cada string del array
                .map(fullName -> fullName.substring(0, 1))
//                Collectors.joining concatena el resultado obtenido en un solo string
                .collect(Collectors.joining())
//                Concatena la fecha, hora, minuto y segundo de manera simplificada
                .concat(String.valueOf(new Date().getTime()));
    }

    public String generateOrderCode(String lastOrderCode) {
        return PREFIX_NAME
                .concat(new SimpleDateFormat("yyyyMMdd").format(new Date()))
                .concat(generateOrderCodeNumber(lastOrderCode));
    }

    private String generateOrderCodeNumber(String lastOrderCode) {
        return String.valueOf(Long.parseLong(lastOrderCode.substring(12))+1);
    }

}
