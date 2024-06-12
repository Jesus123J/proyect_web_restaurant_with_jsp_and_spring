package com.proyect.racoonbrothers.controller.rest;

import com.proyect.racoonbrothers.data.dto.BossOrderDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BossOrderListResponse extends BaseResponse {

    private List<BossOrderDto> bossOrders;

}
