package com.proyect.racoonbrothers.data.mappers;

import com.proyect.racoonbrothers.data.dto.BossOrderDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BossOrderResultMapper implements RowMapper<BossOrderDto> {
    @Override
    public BossOrderDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BossOrderDto(
                rs.getLong(1),
                rs.getString(2),
                rs.getString(3),
                rs.getDouble(4),
                rs.getLong(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8)
        );
    }
}
