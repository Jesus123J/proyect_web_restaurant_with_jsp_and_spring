
package com.utp.management_web_application.data.rest;

import com.utp.management_web_application.data.entity.HistoryAttendanceTb;
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