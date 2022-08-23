package com.lguplus.LTF2_BE.core.repository;

import com.lguplus.LTF2_BE.core.domain.Phone;
import com.lguplus.LTF2_BE.core.domain.PhoneInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneInfoRepository extends JpaRepository<PhoneInfo, Long> {
}
