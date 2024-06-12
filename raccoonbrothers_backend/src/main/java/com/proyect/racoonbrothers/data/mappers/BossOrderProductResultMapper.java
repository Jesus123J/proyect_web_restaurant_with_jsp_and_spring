package com.proyect.racoonbrothers.data.mappers;

import com.proyect.racoonbrothers.data.dto.BossOrderProductDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BossOrderProductResultMapper implements RowMapper<BossOrderProductDto> {
    @Override
    public BossOrderProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BossOrderProductDto(
                rs.getLong(1),
                rs.getLong(2),
                rs.getString(3),
                rs.getString(4),
                rs.getDouble(5),
                rs.getInt(6),
                rs.getDouble(7)
        );
    }
}
