package com.proyect.racoonbrothers.controller;

import com.proyect.racoonbrothers.controller.rest.SendNoticeRequest;
import com.proyect.racoonbrothers.exception.RacoonBrotherException;
import com.proyect.racoonbrothers.controller.rest.LoginRequest;
import com.proyect.racoonbrothers.service.OAuthService;
import com.proyect.racoonbrothers.validator.AuthValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/oauth")
public class OAuthController {

    @Autowired
    AuthValidator authValidator;
    @Autowired
    OAuthService oAuthService;

    //    Login
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws RacoonBrotherException {
        authValidator.validateLogin(loginRequest);
        return ResponseEntity.ok(oAuthService.login(loginRequest));
    }

    //    Enviar aviso
    @PostMapping(value = "/notice/send", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendNotice(@RequestBody SendNoticeRequest sendNoticeRequest) throws RacoonBrotherException {
        return ResponseEntity.ok(oAuthService.sendNotice(sendNoticeRequest));
    }
}
