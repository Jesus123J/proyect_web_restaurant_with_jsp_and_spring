package com.proyect.racoonbrothers.data.dao.impl;

import com.proyect.racoonbrothers.data.dao.OAuthDao;
import com.proyect.racoonbrothers.data.dto.AccountDto;
import com.proyect.racoonbrothers.data.mappers.OAuthAccountResultMapper;
import com.proyect.racoonbrothers.util.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OAuthDaoImpl implements OAuthDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public AccountDto getAccountByUsernameAndPassword(String username, String password) {
        return jdbcTemplate.queryForObject(QueryUtil.SELECT_ACCOUNT_BY_USERNAME_AND_PASSWORD,new OAuthAccountResultMapper(),username,password);
    }

    public List<AccountDto> listAccountByUsernameAndPassword(String username, String password) {
        return jdbcTemplate.query(QueryUtil.SELECT_ACCOUNT_BY_USERNAME_AND_PASSWORD, new OAuthAccountResultMapper(), username, password);
    }
}
