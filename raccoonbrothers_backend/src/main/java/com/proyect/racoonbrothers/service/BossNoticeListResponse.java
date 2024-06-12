package com.proyect.racoonbrothers.service;

import com.proyect.racoonbrothers.controller.rest.BaseResponse;
import com.proyect.racoonbrothers.data.dto.BossNoticeDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BossNoticeListResponse extends BaseResponse {

    List<BossNoticeDto> bossNotices;

}
