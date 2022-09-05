package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.response.PhoneDetailResDto;
import com.lguplus.LTF2_BE.api.dto.response.PhoneResDto;

import java.util.List;

// writer : 최강현
public interface PhoneService {

    // 상품을 전체 조회하는 함수
    List<PhoneResDto> findPhones();
    // 통신 기술에 따른 상품 리스트를 조회하는 함수
    List<PhoneResDto> findPhonesByTelecomTech(String telecomTech);
    // 상품을 상세 조회하는 함수
    PhoneDetailResDto findPhoneDetail(Long phoneId);
}
