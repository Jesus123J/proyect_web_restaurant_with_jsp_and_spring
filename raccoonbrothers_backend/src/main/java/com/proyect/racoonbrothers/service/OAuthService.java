package com.proyect.racoonbrothers.service;


import com.proyect.racoonbrothers.controller.rest.LoginRequest;
import com.proyect.racoonbrothers.controller.rest.LoginResponse;
import com.proyect.racoonbrothers.controller.rest.SendNoticeRequest;
import com.proyect.racoonbrothers.controller.rest.SendNoticeResponse;

public interface OAuthService {
    LoginResponse login(LoginRequest loginRequest);

    SendNoticeResponse sendNotice(SendNoticeRequest sendNoticeRequest);
}
