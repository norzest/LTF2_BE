package com.lguplus.LTF2_BE.api.dto.response;

import com.lguplus.LTF2_BE.core.domain.PublicSupport;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PublicSupportPlanResDto {
    private Long planId;

    private Integer supportPrice;

    public PublicSupportPlanResDto(PublicSupport publicSupport) {
        planId = publicSupport.getPlan().getId();
        supportPrice = publicSupport.getSupportPrice();
    }
}
