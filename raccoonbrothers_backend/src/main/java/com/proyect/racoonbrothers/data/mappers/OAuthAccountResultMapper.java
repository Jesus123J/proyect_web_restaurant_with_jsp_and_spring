package com.proyect.racoonbrothers.data.mappers;

import com.proyect.racoonbrothers.data.dto.AccountDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OAuthAccountResultMapper implements RowMapper<AccountDto> {
    @Override
    public AccountDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AccountDto(
                rs.getLong("idAccount"),
                rs.getLong("idPerson"),
                rs.getInt("status"),
                rs.getString("username"),
                rs.getString("name"),
                rs.getString("lastname"),
                rs.getString("mother_lastname"),
                rs.getInt("idRole"),
                rs.getString("roleType")
        );
    }
}
