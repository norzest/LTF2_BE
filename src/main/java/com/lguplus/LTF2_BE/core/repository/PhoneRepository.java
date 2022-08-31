package com.lguplus.LTF2_BE.core.repository;

import com.lguplus.LTF2_BE.core.domain.enm.ManufacturingCompany;
import com.lguplus.LTF2_BE.core.domain.Phone;
import com.lguplus.LTF2_BE.core.domain.enm.TelecomTech;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    // DB에서 상품 전체를 조회한 후 id 순으로 정렬하여 반환
    List<Phone> findAllByOrderById();

    List<Phone> findByTitleNameContainsOrManufacturingCompany(String titleName, ManufacturingCompany company);

    // DB에서 통신기술에 따른 상품 리스트를 조회한 후 반환
    List<Phone> findByTelecomTech(TelecomTech telecomTech);
}
