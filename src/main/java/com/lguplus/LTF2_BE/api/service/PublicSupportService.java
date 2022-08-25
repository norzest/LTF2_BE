package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.response.PublicSupportPhoneResDto;
import com.lguplus.LTF2_BE.api.dto.response.PublicSupportPlanResDto;

import java.util.List;

public interface PublicSupportService {
    List<PublicSupportPlanResDto> findPublicSupportPlanResDto(Long phoneId);
    List<PublicSupportPhoneResDto> findPublicSupportPhoneResDto(Long planId);
    Integer findPublicSupportResDto(Long phoneId, Long planId);
}
