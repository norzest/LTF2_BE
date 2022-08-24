package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.response.PlanResDto;
import com.lguplus.LTF2_BE.core.domain.MediaService;
import com.lguplus.LTF2_BE.core.domain.Plan;
import com.lguplus.LTF2_BE.core.domain.PlanMediaService;
import com.lguplus.LTF2_BE.core.domain.TelecomTech;
import com.lguplus.LTF2_BE.core.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;

    @Override
    public List<PlanResDto> findAll() {
        List<PlanResDto> result = new ArrayList<>();

        List<Plan> list = planRepository.findAll();

        if(list.size() != 0)
            for(Plan plan: list)
                result.add(buildPlan(plan));

        return result;
    }

    @Override
    public List<PlanResDto> findByTelecomTech(String telecomTech) {
        List<PlanResDto> result = new ArrayList<>();

        List<Plan> list = planRepository.findByTelecomTech(TelecomTech.convertValue(telecomTech));

        if(list.size() != 0)
            for(Plan plan: list)
                result.add(buildPlan(plan));

        return result;
    }

    @Override
    public PlanResDto findOne(Long planId) {
        Plan plan = planRepository.findById(planId).orElse(null);

        return buildPlan(plan);
    }

    private PlanResDto buildPlan(Plan plan) {
        PlanResDto result = null;

        if(plan != null) {
            result = PlanResDto.builder()
                    .id(plan.getId())
                    .name(plan.getName())
                    .monthPrice(plan.getMonthPrice())
                    .data(plan.getData())
                    .dataPlus(plan.getDataPlus())
                    .shareData(plan.getShareData())
                    .shareDataPlus(plan.getShareDataPlus())
                    .voice(plan.getVoice())
                    .voicePlus(plan.getVoicePlus())
                    .message(plan.getMessage())
                    .smartDevice(plan.getSmartDevice())
                    .smartDeviceDiscount(plan.getSmartDeviceDiscount())
                    .premiumService(plan.getPremiumService())
                    .basicBenefit(plan.getBasicBenefit())
                    .familySig5g(plan.getFamilySig5g())
                    .telecomTech(plan.getTelecomTech().name())
                    .planType(plan.getPlanType().name())
                    .mediaServices(plan.getPlanMediaServices()
                            .stream().map(PlanMediaService::getMediaService).collect(Collectors.toList())
                            .stream().map(MediaService::getValue).collect(Collectors.toList()))
                    .build();
        }

        return result;
    }
}
