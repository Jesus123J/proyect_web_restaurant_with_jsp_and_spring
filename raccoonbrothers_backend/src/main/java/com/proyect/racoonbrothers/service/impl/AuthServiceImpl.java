package com.proyect.racoonbrothers.service.impl;

import com.proyect.racoonbrothers.controller.rest.LoginRequest;
import com.proyect.racoonbrothers.controller.rest.LoginResponse;
import com.proyect.racoonbrothers.controller.rest.RegenerateOtpResponse;
import com.proyect.racoonbrothers.controller.rest.VerifyAccountResponse;
import com.proyect.racoonbrothers.data.entity.AccountTb;
import com.proyect.racoonbrothers.data.entity.OtpTb;
import com.proyect.racoonbrothers.data.entity.PersonTb;
import com.proyect.racoonbrothers.repository.AccountRepository;
import com.proyect.racoonbrothers.repository.OtpRepository;
import com.proyect.racoonbrothers.repository.PersonRepository;
import com.proyect.racoonbrothers.repository.RoleRepository;
import com.proyect.racoonbrothers.service.AuthService;
import com.proyect.racoonbrothers.service.EmailService;
import com.proyect.racoonbrothers.util.LogUtil;
import com.proyect.racoonbrothers.util.OtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    OtpRepository otpRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    OtpUtil otpUtil;
    @Autowired
    EmailService emailService;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        LogUtil.info("login() -> loginRequest: username: " + loginRequest.getUsername() + ", passwordIsEmpty: " + loginRequest.getPassword().isBlank());
        Optional<AccountTb> accountExist = accountRepository.findByUsername(loginRequest.getUsername());
        LoginResponse response = new LoginResponse();
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        if (accountExist.isEmpty() || accountExist.get().getStatus().equals(0) || !bcrypt.matches(loginRequest.getPassword(), accountExist.get().getPassword())) {
            response.setStatus(400);
            response.setMessage("username o contraseña inválidas");
        } else {
            AccountTb account = accountExist.get();
            if (!account.getStatus().equals(1)) {
                response.setStatus(401);
                response.setMessage("cuenta inactiva");
            } else if (!account.isEnable()) {
                response.setStatus(403);
                response.setMessage("la cuenta no está verificada");
            } else {
                /*AccountDto user = new AccountDto();
                user.setIdAccount(accountExist.get().getId());*/
//            user.setUsername(accountExist.get().getUsername());
               /* Optional<RoleTb> role = roleRepository.findById(account.getIdRole());*/
//                user.setRole("USER");
               /* user.setRole(role.get().getName().name());*/
                response.setStatus(200);
                response.setMessage("Inicio de sesión exitoso");
//                response.setToken(jwtUtils.generateToken(user));
            }
        }
        LogUtil.info("login() -> status: " + response.getStatus() + ", message: " + response.getMessage());
        return response;
    }

    @Override
    public RegenerateOtpResponse regenerateOtp(String email) {
        RegenerateOtpResponse response = new RegenerateOtpResponse();
        Optional<PersonTb> personExist = personRepository.findByEmail(email);
        if (personExist.isEmpty()) {
            response.setStatus(400);
            response.setMessage("No existe este correo");
        } else {
            Optional<AccountTb> accountExist = accountRepository.findById(personExist.get().getIdAccount());
            if (accountExist.isEmpty()) {
                response.setStatus(400);
                response.setMessage("No existe la cuenta de la persona");
            } else {
                Optional<OtpTb> otpAccountExist = otpRepository.findByIdAccount(accountExist.get().getId());
                if (otpAccountExist.isEmpty()) {
                    response.setStatus(400);
                    response.setMessage("No se encuentra el otp generado por esta cuenta");
                } else {
                    String otpGenerated = otpUtil.generateOtp();

                    emailService.sendOtpEmail(email, otpGenerated);

                    OtpTb otpAccount = otpAccountExist.get();
                    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
                    String otpEncoded = bcrypt.encode(otpGenerated);
                    otpAccount.setOtp(otpEncoded);
                    otpAccount.setCreateTime(new Date());
                    otpAccount.setExpirationTime(new Date(otpAccount.getCreateTime().getTime() + (1000L * 60 * 60 * 24)));

                    otpRepository.save(otpAccount);

                    response.setStatus(200);
                    response.setMessage("Email enviado. Verifique su correo electrónico");
                }
            }
        }
        return response;
    }

    @Override
    public void sendMail(String mail) {
        String otpGenerated = otpUtil.generateOtp();
        emailService.sendOtpEmail(mail, otpGenerated);
    }

    @Override
    public VerifyAccountResponse verifyAccount(String email, String otp) {
        VerifyAccountResponse response = new VerifyAccountResponse();

        Optional<PersonTb> personExist = personRepository.findByEmail(email);
        if (personExist.isEmpty()) {
            response.setStatus(400);
            response.setMessage("No existe este correo");
        } else {
            Optional<AccountTb> accountExist = accountRepository.findById(personExist.get().getIdAccount());
            if (accountExist.isEmpty()) {
                response.setStatus(400);
                response.setMessage("No existe la cuenta de la persona");
            } else {
                Optional<OtpTb> otpAccountExist = otpRepository.findByIdAccount(accountExist.get().getId());
                if (otpAccountExist.isEmpty()) {
                    response.setStatus(400);
                    response.setMessage("No se encuentra el otp generado por esta cuenta");
                } else {
                    OtpTb otpAccount = otpAccountExist.get();
                    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
                    if (!bcrypt.matches(otp, otpAccount.getOtp())) {
                        response.setStatus(400);
                        response.setMessage("Código de verifación incorrecto");
//                      } else if (Duration.between(otpAccount.getCreateTime().toInstant(), LocalDate.now()).getSeconds() < (1000*60*3)) {
                    } else if (!new Date().before(otpAccount.getExpirationTime())) {
                        response.setStatus(400);
                        response.setMessage("Timepo de expirado del OTP. Por favor regenere el código de verificación");
                    } else {
                        AccountTb account = accountExist.get();
                        account.setEnable(true);
                        account.setUpdateTime(new Date());

                        accountRepository.save(account);

                        response.setStatus(200);
                        response.setMessage("Se verificó la cuenta");
                    }
                }
            }

        }
        return response;
    }

//    @Override
//    public RecoverAccountByEmailResponse recoverAccountByEmail(RecoverAccountByEmailRequest recoverAccountByEmailRequest) {
//        RecoverAccountByEmailResponse response = new RecoverAccountByEmailResponse();
//
//
//
//        return response;
//    }
}
