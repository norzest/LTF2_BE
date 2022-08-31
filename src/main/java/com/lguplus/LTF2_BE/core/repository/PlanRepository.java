package com.lguplus.LTF2_BE.core.repository;

import com.lguplus.LTF2_BE.core.domain.Plan;
import com.lguplus.LTF2_BE.core.domain.enm.TelecomTech;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    List<Plan> findByTelecomTech(TelecomTech telecomTech);
}
