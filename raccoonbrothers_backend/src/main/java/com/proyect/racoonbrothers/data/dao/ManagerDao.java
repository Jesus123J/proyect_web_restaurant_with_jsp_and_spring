package com.proyect.racoonbrothers.data.dao;


import com.proyect.racoonbrothers.data.dto.ManagerEmployeeDto;
import com.proyect.racoonbrothers.data.dto.ManagerProductDto;
import com.proyect.racoonbrothers.data.dto.ManagerStockDto;

import java.util.List;

public interface ManagerDao {


    List<ManagerProductDto> listResultManagerProduct();

    List<ManagerEmployeeDto> listResultManagerEmployee();

    List<ManagerStockDto> listResultManagerStock();
}
