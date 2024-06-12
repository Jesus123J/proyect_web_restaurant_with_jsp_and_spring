package com.proyect.racoonbrothers.data.dao;

import com.proyect.racoonbrothers.data.entity.HistoryAttendanceTb;

import java.util.List;

public interface EmployeeDao {

    List<HistoryAttendanceTb> listResultEmployeeEntryTime(Long idAccount);

}
