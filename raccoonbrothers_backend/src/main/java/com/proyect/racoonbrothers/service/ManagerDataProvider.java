package com.proyect.racoonbrothers.service;

import com.proyect.racoonbrothers.data.dao.ManagerDao;
import com.proyect.racoonbrothers.data.dto.ManagerProductDto;

import java.util.List;

public class ManagerDataProvider {

    ManagerDao managerDao;

    public ManagerDataProvider(ManagerDao managerDao){
        this.managerDao = managerDao;
    }

    public List<ManagerProductDto> listResultManagerProduct(){
        return managerDao.listResultManagerProduct();
    }

}
