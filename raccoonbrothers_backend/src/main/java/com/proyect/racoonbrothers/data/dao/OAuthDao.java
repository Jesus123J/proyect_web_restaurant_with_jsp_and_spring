package com.proyect.racoonbrothers.data.dao;

import com.proyect.racoonbrothers.data.dto.AccountDto;

import java.util.List;

public interface OAuthDao {

    AccountDto getAccountByUsernameAndPassword(String username, String password);

    List<AccountDto> listAccountByUsernameAndPassword(String username, String password);

}
