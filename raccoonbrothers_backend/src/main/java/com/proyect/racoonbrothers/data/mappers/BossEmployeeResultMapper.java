package com.proyect.racoonbrothers.data.mappers;

import com.proyect.racoonbrothers.data.dto.BossEmployeeDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BossEmployeeResultMapper implements RowMapper<BossEmployeeDto> {
    @Override
    public BossEmployeeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return BossEmployeeDto.builder()
                .id(rs.getLong(1))
                .idAccount(rs.getLong(2))
                .fullName(rs.getString(3))
                .email(rs.getString(4))
                .cellphone(rs.getString(5))
                .dni(rs.getString(6))
                .accountType(rs.getString(7))
                .build();
    }
}
