package com.proyect.racoonbrothers.service;

import com.proyect.racoonbrothers.controller.rest.LoginRequest;
import com.proyect.racoonbrothers.controller.rest.LoginResponse;
import com.proyect.racoonbrothers.controller.rest.RegenerateOtpResponse;
import com.proyect.racoonbrothers.controller.rest.VerifyAccountResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

    RegenerateOtpResponse regenerateOtp(String email);

    void sendMail(String mail);

    VerifyAccountResponse verifyAccount(String email, String otp);

//    RecoverAccountByEmailResponse recoverAccountByEmail(RecoverAccountByEmailRequest recoverAccountByEmailRequest);
}
