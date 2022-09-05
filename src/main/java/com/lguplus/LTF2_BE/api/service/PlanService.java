package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.response.PlanResDto;

import java.util.List;

// writer : 심영효
public interface PlanService {
    List<PlanResDto> findAll() throws Exception;
    List<PlanResDto> findByTelecomTech(String telecomTech) throws Exception;
    PlanResDto findOne(Long planId) throws Exception;
}
