package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.response.PhoneDetailResDto;
import com.lguplus.LTF2_BE.api.dto.response.PhoneResDto;

import java.util.List;

public interface PhoneService {

    List<PhoneResDto> findPhones();
    List<PhoneResDto> findPhonesByTelecomTech(String telecomTech);
    PhoneDetailResDto findPhoneDetail(Long phoneId);
}
