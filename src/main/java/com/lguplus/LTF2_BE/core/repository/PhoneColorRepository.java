package com.lguplus.LTF2_BE.core.repository;

import com.lguplus.LTF2_BE.core.domain.Phone;
import com.lguplus.LTF2_BE.core.domain.PhoneColor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneColorRepository extends JpaRepository<PhoneColor, Long> {

    // writer : 최강현
    // DB에서 phoneId & colorId로 PhoneColor 조회한 후 반환
    PhoneColor findByPhoneIdAndColorId(Long phoneId, Long colorId);
}
