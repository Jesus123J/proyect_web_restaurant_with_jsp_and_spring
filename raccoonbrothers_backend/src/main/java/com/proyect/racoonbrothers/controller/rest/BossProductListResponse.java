package com.proyect.racoonbrothers.controller.rest;

import com.proyect.racoonbrothers.data.dto.BossProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BossProductListResponse extends BaseResponse{

    List<BossProductDto> bossProducts;

}
