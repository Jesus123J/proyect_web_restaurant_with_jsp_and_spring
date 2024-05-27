/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utp.management_web_application.data.service;

import com.utp.management_web_application.data.rest.BoosRegisterEmployeeResponse;
import com.utp.management_web_application.data.rest.BossRegisterEmployeeRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 *
 * @author Jesus Gutierrez
 */
public interface BossService {

    @POST("/employee/register")
    @Headers("Content-Type: application/json")
    Call<BoosRegisterEmployeeResponse> bossRegisterEmployee(@Header("Authorization") String authorizationHeader, BossRegisterEmployeeRequest bossRegisterEmployeeRequest);

   
}
