/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utp.management_web_application.data.service;

import com.utp.management_web_application.data.rest.LoginRequest;
import com.utp.management_web_application.data.rest.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 *
 * @author Jesus Gutierrez
 */
public interface AuthService {

    @POST("/oauth/login")
    @Headers("Content-Type: application/json")
    Call<LoginResponse> logIn(@Body LoginRequest loginRequest);

}
