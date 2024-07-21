package com.proyect.racoonbrothers.service.impl;

import com.proyect.racoonbrothers.controller.rest.EmployeeRegistryDepartureResponse;
import com.proyect.racoonbrothers.controller.rest.EmployeeRegistryEntryResponse;
import com.proyect.racoonbrothers.data.dao.EmployeeDao;
import com.proyect.racoonbrothers.data.entity.HistoryAttendanceTb;
import com.proyect.racoonbrothers.exception.ExceptionDetails;
import com.proyect.racoonbrothers.exception.RacoonBrotherException;
import com.proyect.racoonbrothers.repository.HistoryAttendanceRepository;
import com.proyect.racoonbrothers.service.EmployeeService;
import com.proyect.racoonbrothers.util.DateUtil;
import com.proyect.racoonbrothers.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    HistoryAttendanceRepository historyAttendanceRepository;
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public EmployeeRegistryEntryResponse employeeRegistryEntry(Long idAccount) throws RacoonBrotherException {
        EmployeeRegistryEntryResponse employeeRegistryEntryResponse = new EmployeeRegistryEntryResponse();
        List<HistoryAttendanceTb> entryTimeExist = employeeDao.listResultEmployeeEntryTime(idAccount);
        boolean registeredEntry = false;
        if (!entryTimeExist.isEmpty()) {
            LogUtil.info(entryTimeExist.toString());
            try {
//                Traemos la fecha, sin horas ni minutos y lo convertimos a milisegundos
                long entryDate = new SimpleDateFormat("yyyy-MM-dd").parse(entryTimeExist.get(0).getEntryTime().toString()).getTime();
                long todayDate = new SimpleDateFormat("yyyy-MM-dd").parse(DateUtil.getDateTimeStamp()).getTime();
                LogUtil.info("entryDate -> " + entryDate + ", todayDate: " + todayDate);
                if (!(entryDate < todayDate)) {
                    registeredEntry = true;
                }
            } catch (Exception e) {
                throw new RacoonBrotherException(new ExceptionDetails("La fecha ingresada no tiene el formato correcto"));
            }
        }
        if (registeredEntry) {
            employeeRegistryEntryResponse.setStatus(400);
            employeeRegistryEntryResponse.setMessage("Ya registró su hora de entrada anteriormente");
        } else {
            HistoryAttendanceTb registryEntryTime = new HistoryAttendanceTb();
            registryEntryTime.setIdAccount(idAccount);
            registryEntryTime.setEntryTime(new Date());
            historyAttendanceRepository.save(registryEntryTime);

            employeeRegistryEntryResponse.setStatus(200);
            employeeRegistryEntryResponse.setMessage("Se registró su hora de entrada");
            System.out.println("Se guardara fecha ");
            employeeRegistryEntryResponse.setDateEntry(new Date());
            System.out.println("La fecha dada se guardo correctamente");

        }
        return employeeRegistryEntryResponse;
    }

    @Override
    public EmployeeRegistryDepartureResponse employeeRegistryDeparture(Long idAccount) throws RacoonBrotherException {
        EmployeeRegistryDepartureResponse employeeRegistryDepartureResponse = new EmployeeRegistryDepartureResponse();
        List<HistoryAttendanceTb> attendanceTodayExist = employeeDao.listResultEmployeeEntryTime(idAccount);
        if (attendanceTodayExist.isEmpty()) {
            employeeRegistryDepartureResponse.setStatus(400);
            employeeRegistryDepartureResponse.setMessage("No tiene registros de asistencia");
        } else {
            try {
                long entryDate = new SimpleDateFormat("yyyy-MM-dd").parse(attendanceTodayExist.get(0).getEntryTime().toString()).getTime();
                long todayDate = new SimpleDateFormat("yyyy-MM-dd").parse(DateUtil.getDateTimeStamp()).getTime();
                LogUtil.info("entryDate -> " + entryDate + ", todayDate: " + todayDate);
                if (!(entryDate == todayDate)) {
                    employeeRegistryDepartureResponse.setStatus(400);
                    employeeRegistryDepartureResponse.setMessage("No registró su hora de entrada el día de hoy");
                } else if (!(attendanceTodayExist.get(0).getDepartureTime() == null)) {
                    employeeRegistryDepartureResponse.setStatus(400);
                    employeeRegistryDepartureResponse.setMessage("Ya registró su hora de salida anteriormente");
                } else {
                    HistoryAttendanceTb registryDepartureTime = attendanceTodayExist.get(0);
                    registryDepartureTime.setDepartureTime(new Date());
                    historyAttendanceRepository.save(registryDepartureTime);
                    employeeRegistryDepartureResponse.setStatus(200);
                    employeeRegistryDepartureResponse.setMessage("Se registró su hora de salida");
                }
            } catch (Exception e) {
                throw new RacoonBrotherException(new ExceptionDetails("La fecha ingresada no tiene el formato correcto"));
            }
        }
        return employeeRegistryDepartureResponse;
    }
}


