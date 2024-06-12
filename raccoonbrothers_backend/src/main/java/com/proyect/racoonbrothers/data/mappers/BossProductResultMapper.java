package com.proyect.racoonbrothers.data.mappers;

import com.proyect.racoonbrothers.data.dto.BossProductDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BossProductResultMapper implements RowMapper<BossProductDto> {
    @Override
    public BossProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {

        return BossProductDto.builder()
                .id(rs.getInt(1))
                .productCode(rs.getString(2))
                .productName(rs.getString(3))
                .productPrice(rs.getDouble(4))
                .build();
    }
}
