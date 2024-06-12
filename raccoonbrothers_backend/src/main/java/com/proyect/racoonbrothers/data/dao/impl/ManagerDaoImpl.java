package com.proyect.racoonbrothers.data.dao.impl;

import com.proyect.racoonbrothers.data.dao.ManagerDao;
import com.proyect.racoonbrothers.data.dto.ManagerEmployeeDto;
import com.proyect.racoonbrothers.data.dto.ManagerProductDto;
import com.proyect.racoonbrothers.data.dto.ManagerStockDto;
import com.proyect.racoonbrothers.data.mappers.ManagerEmployeeResultMapper;
import com.proyect.racoonbrothers.data.mappers.ManagerProductResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ManagerDaoImpl implements ManagerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<ManagerProductDto> listResultManagerProduct() {

        StringBuilder query = new StringBuilder();
        query.append("select ");
        query.append("product.id, ");
        query.append("product.code, ");
        query.append("product.name, ");
        query.append("product.price ");
        query.append("from products product; ");

        return jdbcTemplate.query(query.toString(), new ManagerProductResultMapper());
    }

    @Override
    public List<ManagerEmployeeDto> listResultManagerEmployee() {

        StringBuilder query = new StringBuilder();
        query.append("select ");
        query.append("pe.id, ");
        query.append("concat(pe.name,' ',pe.lastname,' ',pe.mother_lastname) as fullname, ");
        query.append("pe.email, ");
        query.append("pe.cellphone, ");
        query.append("pe.dni, ");
        query.append("rol.name ");
        query.append("from people pe  ");
        query.append("left join accounts ac on ac.id = pe.id_account ");
        query.append("left join roles rol on rol.id = ac.id_role ");
        query.append("where rol.id = 4; ");

        return  jdbcTemplate.query(query.toString(), new ManagerEmployeeResultMapper());
    }

    @Override
    public List<ManagerStockDto> listResultManagerStock() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        query.append("id, ");
        query.append("name, ");
        query.append("unit, ");
        query.append("price_unit as priceUnit, ");
        query.append("amount ");
        query.append("FROM STOCK; ");

        return jdbcTemplate.query(query.toString(), new ManagerStockResultMapper());
    }
}
