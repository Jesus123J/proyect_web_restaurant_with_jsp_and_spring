package com.proyect.racoonbrothers.service;

import com.proyect.racoonbrothers.controller.rest.EmployeeRegistryDepartureResponse;
import com.proyect.racoonbrothers.controller.rest.EmployeeRegistryEntryResponse;
import com.proyect.racoonbrothers.exception.RacoonBrotherException;

public interface EmployeeService {
    EmployeeRegistryEntryResponse employeeRegistryEntry(Long idAccount) throws RacoonBrotherException;

    EmployeeRegistryDepartureResponse employeeRegistryDeparture(Long idAccount) throws RacoonBrotherException;
}
