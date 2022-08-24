package com.lguplus.LTF2_BE.core.repository;

import com.lguplus.LTF2_BE.core.domain.Phone;
import com.lguplus.LTF2_BE.core.domain.PhoneColor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneColorRepository extends JpaRepository<PhoneColor, Long> {

    PhoneColor findByPhoneIdAndColorId(Long phoneId, Long colorId);
}
