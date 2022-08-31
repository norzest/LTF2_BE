package com.lguplus.LTF2_BE.core.repository;

import com.lguplus.LTF2_BE.core.domain.enm.ManufacturingCompany;
import com.lguplus.LTF2_BE.core.domain.Phone;
import com.lguplus.LTF2_BE.core.domain.enm.TelecomTech;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    List<Phone> findAllByOrderById();

    List<Phone> findByTitleNameContainsOrManufacturingCompany(String titleName, ManufacturingCompany company);

    List<Phone> findByTelecomTech(TelecomTech telecomTech);
}
