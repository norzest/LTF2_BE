package com.lguplus.LTF2_BE.core.repository;

import com.lguplus.LTF2_BE.core.domain.Phone;
import com.lguplus.LTF2_BE.core.domain.PhoneColor;
import com.lguplus.LTF2_BE.core.domain.PhoneImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneImgRepository extends JpaRepository<PhoneImg, Long> {

    // DB에서 PhoneColor로 이미지 리스트 조회한 후 반환
    List<PhoneImg> findByPhoneColor(PhoneColor phoneColor);
}
