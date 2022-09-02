package com.lguplus.LTF2_BE.core.repository;

import com.lguplus.LTF2_BE.core.domain.PublicSupport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicSupportRepository extends JpaRepository<PublicSupport, Long> {
    // DB에서 핸드폰에 맞는 공시지원금을 조회하여 List<PublicSupport> 반환
    List<PublicSupport> findAllOrderByPhoneId(Long phoneId);
    // DB에서 요금제에 맞는 공시지원금을 조회하여 List<PublicSupport> 반환
    List<PublicSupport> findAllOrderByPlanId(Long planId);
    // DB에서 핸드폰과 요금제에 맞는 공시지원금을 조회하여 PublicSupport 객체 반환
    PublicSupport findByPhoneIdAndPlanId(Long phoneId, Long planId);
}