package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.response.PlanResDto;

import java.util.List;

public interface PlanService {
    List<PlanResDto> findAll();
    List<PlanResDto> findByTelecomTech(String telecomTech);
    PlanResDto findOne(Long planId);
}
