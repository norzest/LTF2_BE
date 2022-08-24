package com.lguplus.LTF2_BE.core.repository;

import com.lguplus.LTF2_BE.core.domain.PublicSupport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicSupportRepository extends JpaRepository<PublicSupport, Long> {
    List<PublicSupport> findAllOrderByPhoneId(Long phoneId);
    List<PublicSupport> findAllOrderByPlanId(Long planId);
    PublicSupport findByPhoneIdAndPlanId(Long phoneId, Long planId);
}
