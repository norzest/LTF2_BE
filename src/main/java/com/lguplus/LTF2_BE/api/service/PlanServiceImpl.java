package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.response.PlanResDto;
import com.lguplus.LTF2_BE.core.domain.Plan;
import com.lguplus.LTF2_BE.core.domain.enm.TelecomTech;
import com.lguplus.LTF2_BE.core.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;

    // 요금제 전체를 조회하는 함수
    @Override
    public List<PlanResDto> findAll() throws Exception {
        // DB 에서 요금제 전체를 조회하여 Plan 배열 반환
        List<Plan> list = planRepository.findAll();

        // List<Plan>을 List<PlanResDto>로 변환하여 리턴
        return list.stream().map(PlanResDto::new).collect(Collectors.toList());
    }

    // 통신 기술에 따른 요금제 리스트를 조회하는 함수
    @Override
    public List<PlanResDto> findByTelecomTech(String telecomTech) throws Exception {
        // DB 에서 통신 기술에 따른 요금제 리스트를 조회하여 Plan 배열 반환
        List<Plan> list = planRepository.findByTelecomTech(TelecomTech.convertValue(telecomTech));

        // List<Plan>을 List<PlanResDto>로 변환하여 리턴
        return list.stream().map(PlanResDto::new).collect(Collectors.toList());
    }

    // 특정 요금제를 조회하는 함수
    @Override
    public PlanResDto findOne(Long planId) throws Exception {
        // DB 에서 planId를 id로 갖는 요금제 한개를 찾아 Plan 으로 반환, 없을 경우 null 을 반환
        Plan plan = planRepository.findById(planId).orElse(null);
        // plan 이 null 이 아닐 경우 PlanResDto 로 가공하여 반환
        if (plan != null)
            return new PlanResDto(plan);
        // null 일 경우 그대로 null 반환
        else
            return null;
    }

}
