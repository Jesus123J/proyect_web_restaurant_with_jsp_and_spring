package com.proyect.racoonbrothers.data.mappers;


import com.proyect.racoonbrothers.data.dto.BossStockDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BossStockResultMapper implements RowMapper<BossStockDto> {
    @Override
    public BossStockDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BossStockDto(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getDouble(4),
                rs.getInt(5)
        );
    }
}
