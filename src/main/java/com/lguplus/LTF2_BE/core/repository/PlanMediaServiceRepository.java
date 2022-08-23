package com.lguplus.LTF2_BE.core.repository;

import com.lguplus.LTF2_BE.core.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanMediaServiceRepository extends JpaRepository<Phone, Long> {
}
