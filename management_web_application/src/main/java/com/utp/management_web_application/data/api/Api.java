/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.data.api;

import com.utp.management_web_application.config.ConfigConnection;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author Jesus Gutierrez
 * @param <T>
 */
public class Api<T> {

    private static Retrofit retrofit = null;
    protected T service;

    
    public Api(Class<T> serviceClass){
        
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                .baseUrl(ConfigConnection.BASE_URL.getNombre())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }
        service = retrofit.create(serviceClass);
    }

}
