package com.lguplus.LTF2_BE.api.dto.response;

import com.lguplus.LTF2_BE.core.domain.PublicSupport;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;

@Data
@NoArgsConstructor
public class PublicSupportPhoneResDto {
    private Long phoneId;

    private Integer supportPrice;

    public PublicSupportPhoneResDto(PublicSupport publicSupport){
        phoneId = publicSupport.getPhone().getId();
        supportPrice = publicSupport.getSupportPrice();
    }
}
