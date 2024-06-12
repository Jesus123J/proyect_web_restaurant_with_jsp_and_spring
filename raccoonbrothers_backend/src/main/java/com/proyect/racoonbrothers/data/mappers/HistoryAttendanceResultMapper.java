package com.proyect.racoonbrothers.data.mappers;

import com.proyect.racoonbrothers.data.entity.HistoryAttendanceTb;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoryAttendanceResultMapper implements RowMapper<HistoryAttendanceTb> {
    @Override
    public HistoryAttendanceTb mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new HistoryAttendanceTb(
                rs.getLong(1),
                rs.getLong(2),
                rs.getTimestamp(3),
                rs.getTimestamp(4)
        );
    }
}
