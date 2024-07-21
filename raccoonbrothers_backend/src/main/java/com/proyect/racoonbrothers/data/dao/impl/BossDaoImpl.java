package com.proyect.racoonbrothers.data.dao.impl;

import com.proyect.racoonbrothers.data.dao.BossDao;
import com.proyect.racoonbrothers.data.dto.*;
import com.proyect.racoonbrothers.data.mappers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BossDaoImpl implements BossDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BossEmployeeDto> listResultBossEmployee() {

        StringBuilder query = new StringBuilder();
        query.append("select ");
        query.append("pe.id, ");
        query.append("pe.id_account, ");
        query.append("concat(pe.name,' ',pe.lastname,' ',pe.mother_lastname) as fullname, ");
        query.append("pe.email, ");
        query.append("pe.cellphone, ");
        query.append("pe.dni, ");
        query.append("rol.name ");
        query.append("from people pe  ");
        query.append("left join accounts ac on ac.id = pe.id_account ");
        query.append("left join roles rol on rol.id = ac.id_role ");
        query.append("where rol.id != 1 and rol.id != 2; ");

        return jdbcTemplate.query(query.toString(), new BossEmployeeResultMapper());
    }

    @Override
    public List<BossProductDto> listResultBossProduct() {

        StringBuilder query = new StringBuilder();
        query.append("select ");
        query.append("product.id, ");
        query.append("product.code, ");
        query.append("product.name, ");
        query.append("product.price ");
        query.append("from products product; ");

        return jdbcTemplate.query(query.toString(), new BossProductResultMapper());
    }

    @Override
    public List<BossOrderDto> listResultBossOrder() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        query.append("rcorder.id, ");
        query.append("rcorder.order_code, ");
        query.append("rcorder.client_name, ");
        query.append("rcorder.order_price, ");
        query.append("rcorder.id_account, ");
        query.append("CONCAT(person.name,' ',person.lastname,' ',person.mother_lastname) AS fullname ");
        query.append("FROM RECORD_ORDERS rcorder ");
        query.append("LEFT JOIN PEOPLE person ON person.id_account = rcorder.id_account; ");

        return jdbcTemplate.query(query.toString(), new BossOrderResultMapper());
    }


    @Override
    public List<BossOrderProductDto> listResultBossOrderProduct(Long idRecordOrder) {

        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        query.append("orderProduct.id, ");
        query.append("product.id as idProduct, ");
        query.append("orderProduct.product_code as productCode, ");
        query.append("product.name as nameProduct, ");
        query.append("product.price as priceUnit, ");
        query.append("orderProduct.amount_product as amountProduct, ");
        query.append("orderProduct.price_products as priceProducts ");
        query.append("FROM ORDER_PRODUCTS orderProduct ");
        query.append("LEFT JOIN PRODUCTS product ON product.code = orderProduct.product_code ");
        query.append("LEFT JOIN RECORD_ORDERS recordOrder ON recordOrder.id = orderProduct.id_record_orders ");
        query.append("WHERE recordOrder.id = (?); ");

        return jdbcTemplate.query(query.toString(), new BossOrderProductResultMapper(),idRecordOrder);
    }

    @Override
    public List<BossStockDto> listResultBossStock() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        query.append("id, ");
        query.append("name, ");
        query.append("unit, ");
        query.append("price_unit as priceUnit, ");
        query.append("amount ");
        query.append("FROM STOCK; ");

        return jdbcTemplate.query(query.toString(), new BossStockResultMapper());
    }

    @Override
    public List<BossNoticeDto> listResultBossNotice() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        query.append("notice.id as idRecordNotice, ");
        query.append("notice.id_account as idAccount, ");
        query.append("notice.id_person as idPerson, ");
        query.append("notice.description, ");
        query.append("notice.read_boss as readBoss, ");
        query.append("person.name as name, ");
        query.append("person.lastname as lastname, ");
        query.append("person.mother_lastname as motherLastname, ");
        query.append("notice.create_time as createTime, ");
        query.append("notice.update_time as updateTime ");
        query.append("FROM record_notices notice ");
        query.append("LEFT JOIN people person ON person.id = notice.id_person ");
        query.append("LEFT JOIN accounts account ON account.id = notice.id_account ");
        query.append("WHERE account.status = 1 OR account.status = 9; ");

        return jdbcTemplate.query(query.toString(), new BossNoticeResultMapper());
    }
}
