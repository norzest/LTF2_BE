package com.lguplus.LTF2_BE;

import com.lguplus.LTF2_BE.api.dto.response.PublicSupportPhoneResDto;
import com.lguplus.LTF2_BE.api.dto.response.PublicSupportPlanResDto;
import com.lguplus.LTF2_BE.api.service.PublicSupportService;
import com.lguplus.LTF2_BE.core.domain.Phone;
import com.lguplus.LTF2_BE.core.domain.Plan;
import com.lguplus.LTF2_BE.core.repository.PhoneRepository;
import com.lguplus.LTF2_BE.core.repository.PlanRepository;
import com.lguplus.LTF2_BE.core.repository.PublicSupportRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class PublicSupportServiceTest {

    @Autowired
    private PublicSupportService publicSupportService;

    @Autowired
    private PublicSupportRepository publicSupportRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private PlanRepository planRepository;

    @BeforeEach
    void before() {
        getPhone();
        getPlan();
    }

    private Phone phone;
    private Plan plan;

    @Test
    public void findByPhoneId() {
        // given
        Long phoneId = phone.getId();

        // when
        List<PublicSupportPlanResDto> lst = publicSupportService.findPublicSupportPlanResDto(phoneId);

        // then
        Assertions.assertThat(lst).isNotNull();
        Assertions.assertThat(lst.size()).isEqualTo(16);
        Assertions.assertThat(lst.stream().findFirst().get().getSupportPrice()).isEqualTo(575000);
    }

    @Test
    public void findByPlanId() {
        // given
        Long planId = plan.getId();

        // when
        List<PublicSupportPhoneResDto> lst = publicSupportService.findPublicSupportPhoneResDto(planId);

        // then
        Assertions.assertThat(lst).isNotNull();
        Assertions.assertThat(lst.size()).isEqualTo(20);
        Assertions.assertThat(lst.stream().findFirst().get().getSupportPrice()).isEqualTo(575000);
    }

    @Test
    public void findByPlanIdByPhoneId() {
        // given
        Long phoneId = phone.getId();
        Long planId = plan.getId();

        // when
        int result = publicSupportService.findPublicSupportResDto(phoneId, planId);

        // then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isEqualTo(575000);
    }

    private void getPhone() {
        phone = phoneRepository.findById(1L).orElse(null);
        Assertions.assertThat(phone).isNotNull();
    }

    private void getPlan() {
        plan = planRepository.findById(1L).orElse(null);
        Assertions.assertThat(plan).isNotNull();
    }
}