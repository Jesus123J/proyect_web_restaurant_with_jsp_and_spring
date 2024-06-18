/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utp.management_web_application.data.service;

import com.utp.management_web_application.data.dto.AccountDto;
import com.utp.management_web_application.data.rest.ManagerEmployeeListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 *
 * @author Jesus Gutierrez
 */
public interface ManagerService {

    @GET("/manager/dataManager")
    @Headers("Content-Type: application/json")
    Call<AccountDto> dataCompletMamager(@Header("Authorization") String token);

    @GET("/manager/employee/list")
    @Headers("Content-Type: application/json")
    Call<ManagerEmployeeListResponse> listManagerEmployee(@Header("Authorization") String token);

}
