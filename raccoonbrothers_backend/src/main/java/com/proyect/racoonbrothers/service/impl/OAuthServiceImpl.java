package com.proyect.racoonbrothers.service.impl;

import com.proyect.racoonbrothers.controller.rest.SendNoticeRequest;
import com.proyect.racoonbrothers.controller.rest.SendNoticeResponse;
import com.proyect.racoonbrothers.data.dao.OAuthDao;
import com.proyect.racoonbrothers.data.dto.AccountDto;
import com.proyect.racoonbrothers.controller.rest.LoginRequest;
import com.proyect.racoonbrothers.controller.rest.LoginResponse;
import com.proyect.racoonbrothers.data.entity.AccountTb;
import com.proyect.racoonbrothers.data.entity.PersonTb;
import com.proyect.racoonbrothers.data.entity.RecordNoticeTb;
import com.proyect.racoonbrothers.repository.AccountRepository;
import com.proyect.racoonbrothers.repository.PersonRepository;
import com.proyect.racoonbrothers.repository.RecordNoticeRepository;
import com.proyect.racoonbrothers.service.ISendPasswordEmail;
import com.proyect.racoonbrothers.service.OAuthService;
import com.proyect.racoonbrothers.util.LogUtil;
import com.proyect.racoonbrothers.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OAuthServiceImpl implements OAuthService {

    @Autowired
    OAuthDao oAuthDao;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    RecordNoticeRepository recordNoticeRepository;
    @Autowired
    ISendPasswordEmail sendPasswordEmail;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        LogUtil.info("login() -> loginRequest: username: " + loginRequest.getUsername() + ", passwordIsEmpty: " + loginRequest.getPassword().isBlank());
        LoginResponse loginResponse = new LoginResponse();
        List<AccountDto> accounts = oAuthDao.listAccountByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (accounts.isEmpty()) {
            loginResponse.setStatus(401);
            loginResponse.setMessage("Usuario o contrasña inválidas");
        } else {
            AccountDto account = accounts.get(0);
            if (account.getStatus() != 1) {
                loginResponse.setStatus(403);
                loginResponse.setMessage("Su cuenta se encuentra bloqueada");
            } else {
                loginResponse.setStatus(200);
                loginResponse.setMessage("Inicio de sesión exitoso");
                loginResponse.setRoleType(account.getRoleType());
                loginResponse.setToken(TokenUtil.generateToken(account));
            }
        }
        return loginResponse;
    }

    @Override
    public SendNoticeResponse sendNotice(SendNoticeRequest sendNoticeRequest) {

        Optional<PersonTb> personExist = personRepository.findByDni(sendNoticeRequest.getDni());
        if (personExist.isEmpty()){
            return new SendNoticeResponse(400,"No existe la persona con este dni");
        }
        new SendNoticeResponse(400,"No existe la cuenta relacionada a la persona");
        Optional<AccountTb> accountExist = accountRepository.findById(personExist.get().getIdAccount());
        if (accountExist.isEmpty()){
            return new SendNoticeResponse(400,"No existe la cuenta relacionada a la persona");
        }

        Optional<RecordNoticeTb> noticeExist = recordNoticeRepository.findByIdAccount(accountExist.get().getId());
        if (noticeExist.isPresent() && !(noticeExist.get().getCreateTime().getTime()+259200000L< new Date().getTime())){
            return new SendNoticeResponse(400,"Ya ha enviado un aviso anteriormente");
        }

        RecordNoticeTb recordNotice = new RecordNoticeTb();
        String description = "Me olvidé la contraseña, por favor restablezcala";
        recordNotice.setIdAccount(accountExist.get().getId());
        recordNotice.setIdPerson(personExist.get().getId());
        recordNotice.setDescription(description);
        recordNotice.setReadBoss(0);
        recordNotice.setCreateTime(new Date());
        recordNotice.setUpdateTime(recordNotice.getCreateTime());

        recordNoticeRepository.save(recordNotice);

//        sendPasswordEmail.sendPasswordEmail(personExist.get().getEmail(),accountExist.get().getPassword());

        return new SendNoticeResponse(200, "Se envió el aviso correctamente");
    }
}
