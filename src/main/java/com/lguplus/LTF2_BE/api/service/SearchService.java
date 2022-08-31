package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.response.PhoneResDto;

import java.util.List;

public interface SearchService {

    List<PhoneResDto> searchPhones(String keyWord) throws Exception;
}
