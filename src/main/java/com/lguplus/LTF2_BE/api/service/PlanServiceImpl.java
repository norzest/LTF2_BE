package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.response.PlanResDto;
import com.lguplus.LTF2_BE.core.domain.Plan;
import com.lguplus.LTF2_BE.core.domain.TelecomTech;
import com.lguplus.LTF2_BE.core.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;

    @Override
    public List<PlanResDto> findAll() throws Exception {
        List<Plan> list = planRepository.findAll();

        return list.stream().map(PlanResDto::new).collect(Collectors.toList());
    }

    @Override
    public List<PlanResDto> findByTelecomTech(String telecomTech) throws Exception {
        List<Plan> list = planRepository.findByTelecomTech(TelecomTech.convertValue(telecomTech));

        return list.stream().map(PlanResDto::new).collect(Collectors.toList());
    }

    @Override
    public PlanResDto findOne(Long planId) throws Exception {
        Plan plan = planRepository.findById(planId).orElse(null);
        if (plan != null)
            return new PlanResDto(plan);
        else
            return null;
    }

}
