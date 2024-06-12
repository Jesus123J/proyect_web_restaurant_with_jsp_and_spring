package com.proyect.racoonbrothers.service;

import com.proyect.racoonbrothers.controller.rest.*;
import com.proyect.racoonbrothers.controller.rest.BossOrderListResponse;

public interface BossService {
    BoosRegisterEmployeeResponse bossRegisterEmployee(BossRegisterEmployeeRequest bossRegisterEmployeeRequest);

    BossEmployeeListResponse listBossEmployee();

    BossRegisterProductResponse bossRegisterProduct(BossRegisterProductRequest bossRegisterProductRequest);

    BossProductListResponse listBossProduct();

    BossOrderListResponse listBossOrder();

    BossOrderProductListResponse listBossOrderProduct(Long idRecordOrder);

    BossAttendanceListResponse listBossHistoryAttendance();

    BossAttendanceEmployeeListResponse listBossEmployeeHistoryAttendance(Long idAccount);

    BossEditEmployeeResponse bossEditEmployee(BossEditEmployeeRequest bossEditEmployeeRequest);

    BossEditAccountEmployeeResponse bossEditAccountEmployee(BossEditAccountEmployeeRequest bossEditAccountEmployeeRequest);

    BossRegisterStockResponse bossRegisterStock(BossRegisterStockRequest bossRegisterStockRequest);

    BossStockListResponse listBossStock();

    BossRegisterStockAmountResponse bossRegisterStockAmount(BossRegisterStockAmountRequest bossRegisterStockAmountRequest);

    BossEditStockResponse bossEditStock(BossEditStockRequest bossEditStockRequest);

    BossNoticeListResponse listBossNotice();
}
