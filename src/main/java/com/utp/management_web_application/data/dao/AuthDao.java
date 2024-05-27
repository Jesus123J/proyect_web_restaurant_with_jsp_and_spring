/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.data.dao;

import com.utp.management_web_application.data.api.Api;
import com.utp.management_web_application.data.rest.LoginRequest;
import com.utp.management_web_application.data.rest.LoginResponse;
import com.utp.management_web_application.data.service.AuthService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import retrofit2.Call;

/**
 *
 * @author Jesus Gutierrez
 */
public class AuthDao extends Api<AuthService> {

    public AuthDao() {
        super(AuthService.class);
    }

    public  LoginResponse logIn(LoginRequest loginRequest) {
        try {
            return service.logIn(loginRequest).execute().body();
        } catch (IOException ex) {
            return null;
        }
    }
}
