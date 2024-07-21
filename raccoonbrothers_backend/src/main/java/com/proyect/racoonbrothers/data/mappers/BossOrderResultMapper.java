package com.proyect.racoonbrothers.data.mappers;

import com.proyect.racoonbrothers.data.dto.BossOrderDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BossOrderResultMapper implements RowMapper<BossOrderDto> {
    @Override
    public BossOrderDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BossOrderDto(
                rs.getLong(1), // id
                rs.getString(2), // orderCode
                rs.getString(3), // clientName
                rs.getDouble(4), // orderPrice
                rs.getLong(5), // idAccount
                rs.getString(6), // fullName
                null, // createTime (no está en la consulta SQL, puedes ajustar según necesidad)
                null // updateTime (no está en la consulta SQL, puedes ajustar según necesidad)
        );
    }
}


