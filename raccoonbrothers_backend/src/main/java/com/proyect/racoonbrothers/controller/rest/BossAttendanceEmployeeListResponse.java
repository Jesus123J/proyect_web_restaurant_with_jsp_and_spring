package com.proyect.racoonbrothers.controller.rest;

import com.proyect.racoonbrothers.data.entity.HistoryAttendanceTb;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BossAttendanceEmployeeListResponse extends BaseResponse{

    List<HistoryAttendanceTb> bossEmployeeHistoryAttendances;

}
