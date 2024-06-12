package com.proyect.racoonbrothers.controller.rest;

import com.proyect.racoonbrothers.data.dto.BossStockDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BossStockListResponse extends BaseResponse {

    List<BossStockDto> bossStocks;

}
