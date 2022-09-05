package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.response.PublicSupportPhoneResDto;
import com.lguplus.LTF2_BE.api.dto.response.PublicSupportPlanResDto;

import java.util.List;

public interface PublicSupportService {
    // 핸드폰에 맞는 공시지원금을 조회하는 함수
    List<PublicSupportPlanResDto> findPublicSupportPlanResDto(Long phoneId);
    // 요금제에 맞는 공시지원금을 조회하는 함수
    List<PublicSupportPhoneResDto> findPublicSupportPhoneResDto(Long planId);
    // 핸드폰과 요금제에 맞는 공시지원금을 조회하는 함수
    Integer findPublicSupportResDto(Long phoneId, Long planId);
}