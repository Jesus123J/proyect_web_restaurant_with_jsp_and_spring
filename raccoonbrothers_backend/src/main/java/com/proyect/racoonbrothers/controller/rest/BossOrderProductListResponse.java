package com.proyect.racoonbrothers.controller.rest;

import com.proyect.racoonbrothers.data.dto.BossOrderProductDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BossOrderProductListResponse extends BaseResponse{

    private List<BossOrderProductDto> bossOrderProducts;

}
