package com.lguplus.LTF2_BE.core.repository;

import com.lguplus.LTF2_BE.core.domain.Plan;
import com.lguplus.LTF2_BE.core.domain.enm.TelecomTech;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    // DB에서 통신기술에 따른 요금제 리스트를 조회한 후 반환
    List<Plan> findByTelecomTech(TelecomTech telecomTech);
}
