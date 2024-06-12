package com.proyect.racoonbrothers.data.dao.impl;

import com.proyect.racoonbrothers.data.dto.ManagerStockDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerStockResultMapper implements RowMapper<ManagerStockDto> {
    @Override
    public ManagerStockDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ManagerStockDto(
                rs.getLong(1),
                rs.getString(2),
                rs.getString(3),
                rs.getDouble(4),
                rs.getInt(5)
        );
    }
}
