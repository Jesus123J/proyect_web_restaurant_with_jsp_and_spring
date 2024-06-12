package com.proyect.racoonbrothers.data.mappers;


import com.proyect.racoonbrothers.data.dto.BossNoticeDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BossNoticeResultMapper implements RowMapper<BossNoticeDto> {
    @Override
    public BossNoticeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BossNoticeDto(
                rs.getLong(1),
                rs.getLong(2),
                rs.getLong(3),
                rs.getString(4),
                rs.getInt(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8),
                rs.getString(9),
                rs.getString(10)
        );
    }
}
