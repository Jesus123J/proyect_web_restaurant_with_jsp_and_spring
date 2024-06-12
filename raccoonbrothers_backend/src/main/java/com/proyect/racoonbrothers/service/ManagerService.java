package com.proyect.racoonbrothers.service;

import com.proyect.racoonbrothers.controller.rest.*;
import com.proyect.racoonbrothers.data.dto.AccountDto;

public interface ManagerService {
    ManagerProductListResponse listManagerProduct();

    ManagerEmployeeListResponse listManagerEmployee();

    ManagerRegisterOrderResponse managerRegisterOrder(AccountDto token, ManagerRegisterOrderRequest managerRegisterOrderRequest);

    ManagerStockListResponse listManagerStock();
}
