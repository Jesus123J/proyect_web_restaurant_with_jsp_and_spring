package com.proyect.racoonbrothers.data.dao.impl;

import com.proyect.racoonbrothers.data.dao.EmployeeDao;
import com.proyect.racoonbrothers.data.entity.HistoryAttendanceTb;
import com.proyect.racoonbrothers.data.mappers.HistoryAttendanceResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<HistoryAttendanceTb> listResultEmployeeEntryTime(Long idAccount) {

        StringBuilder query = new StringBuilder();
        query.append("SELECT  ");
        query.append("* ");
        query.append("FROM history_attendance  ");
        query.append("WHERE id_account = (?) ");
        query.append("ORDER BY id DESC  ");
        query.append("LIMIT 1; ");
        return jdbcTemplate.query(query.toString(),new HistoryAttendanceResultMapper(),idAccount);
    }
}
