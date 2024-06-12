package com.proyect.racoonbrothers.controller.rest;

import com.proyect.racoonbrothers.data.dto.ManagerProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ManagerProductListResponse extends BaseResponse {

    List<ManagerProductDto> managerProducts;

}
