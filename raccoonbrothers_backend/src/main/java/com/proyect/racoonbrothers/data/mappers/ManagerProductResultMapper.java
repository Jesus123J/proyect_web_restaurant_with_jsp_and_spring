package com.proyect.racoonbrothers.data.mappers;

import com.proyect.racoonbrothers.data.dto.ManagerProductDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerProductResultMapper implements RowMapper<ManagerProductDto> {
    @Override
    public ManagerProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ManagerProductDto.builder()
                .id(rs.getInt(1))
                .code(rs.getString(2))
                .name(rs.getString(3))
                .price(rs.getDouble(4))
                .build();
    }
}
