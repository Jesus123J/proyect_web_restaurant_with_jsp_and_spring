package com.proyect.racoonbrothers.data.mappers;

import com.proyect.racoonbrothers.data.dto.ManagerEmployeeDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerEmployeeResultMapper implements RowMapper<ManagerEmployeeDto> {
    @Override
    public ManagerEmployeeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ManagerEmployeeDto(
                rs.getLong(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6));
    }
}
