package com.proyect.racoonbrothers.data.dao;

import com.proyect.racoonbrothers.data.dto.*;

import java.util.List;

public interface BossDao {

    List<BossEmployeeDto> listResultBossEmployee();

    List<BossProductDto> listResultBossProduct();

    List<BossOrderDto> listResultBossOrder();

    List<BossOrderProductDto> listResultBossOrderProduct(Long idRecordOrder);

    List<BossStockDto> listResultBossStock();

    List<BossNoticeDto> listResultBossNotice();
}
