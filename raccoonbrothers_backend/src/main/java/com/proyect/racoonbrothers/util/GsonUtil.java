package com.proyect.racoonbrothers.util;

import com.google.gson.Gson;

import java.util.Base64;

public class GsonUtil {

    public static String serialize(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static <T>T toObject(String json, Class<T> genericClass){
        Gson gson = new Gson();
        String decoder = new String(Base64.getDecoder().decode(json));
        return gson.fromJson(decoder,genericClass);
    }

}
