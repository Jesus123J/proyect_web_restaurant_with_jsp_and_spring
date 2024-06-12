package com.proyect.racoonbrothers.repository;

import com.proyect.racoonbrothers.data.entity.HistoryAttendanceTb;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryAttendanceRepository extends JpaRepository<HistoryAttendanceTb,Long> {

    List<HistoryAttendanceTb> findAllByIdAccount(Long idAccount, Sort id);
}
