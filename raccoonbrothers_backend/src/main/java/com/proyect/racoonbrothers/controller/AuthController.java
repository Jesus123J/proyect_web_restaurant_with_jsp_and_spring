package com.proyect.racoonbrothers.controller;

import com.proyect.racoonbrothers.exception.RacoonBrotherException;
import com.proyect.racoonbrothers.controller.rest.LoginRequest;
import com.proyect.racoonbrothers.service.AuthService;
import com.proyect.racoonbrothers.validator.AuthValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    @Autowired
    AuthValidator authValidator;
    @Autowired
    AuthService authService;

    @GetMapping(value = "/hello")
    public void hello() {
        System.out.println("Hola");
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(/*@RequestBody MultiValueMap<String,String>paramMap*/
            @RequestBody LoginRequest loginRequest,
            @RequestHeader HttpHeaders httpHeaders) throws RacoonBrotherException {
        authValidator.validateLogin(loginRequest);

        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @GetMapping(value = "/verify-account")
    public ResponseEntity<?> verifyAccount(@RequestParam String email, @RequestParam String otp) {
        return ResponseEntity.ok(authService.verifyAccount(email, otp));
    }

//    Recuperar cuenta mediante correo
//    @PostMapping(value = "/login/recover-account/email")
//    public ResponseEntity<?> recoverAccountByEmail(@RequestBody RecoverAccountByEmailRequest recoverAccountByEmailRequest){
//        return ResponseEntity.ok(authService.recoverAccountByEmail(recoverAccountByEmailRequest));
//    }


    //    Obtener el código OTP para activar la cuenta
    @PostMapping(value = "/regenerate-otp")
    public ResponseEntity<?> regenerateOtp(@RequestParam String email) {
        return ResponseEntity.ok(authService.regenerateOtp(email));
    }

    //    Obtener el código OTP, prueba sin log
    @PostMapping(value = "/send-mail")
    public void sendMail(@RequestParam String mail) {
        authService.sendMail(mail);
    }

}
