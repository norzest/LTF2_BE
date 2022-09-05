package com.lguplus.LTF2_BE;

import com.lguplus.LTF2_BE.api.dto.response.PlanResDto;
import com.lguplus.LTF2_BE.api.service.PlanService;
import com.lguplus.LTF2_BE.core.domain.Plan;
import com.lguplus.LTF2_BE.core.repository.PlanRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Transactional
public class PlanServiceTest {

    @Autowired
    private PlanService planService;

    @Autowired
    private PlanRepository planRepository;

    @Test
    public void findPlansTest() {
        try {
            // when
            List<PlanResDto> plans = planService.findAll();

            //then
            Assertions.assertThat(plans).isNotNull();
            Assertions.assertThat(plans.stream().findFirst().get().getName()).isEqualTo("5G 시그니처");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void findPlansByTelecomTechTest() {
        // given
        String telecomTech5G = "5G";
        String telecomTech4G = "LTE";


        try {
            //when
            List<PlanResDto> plan5G = planService.findByTelecomTech(telecomTech5G);
            List<PlanResDto> plan4G = planService.findByTelecomTech(telecomTech4G);

            //then
            Assertions.assertThat(plan5G).isNotNull();
            Assertions.assertThat(plan5G.stream().findFirst().get().getName()).isEqualTo("5G 시그니처");
            Assertions.assertThat(plan4G).isNotNull();
            Assertions.assertThat(plan4G.stream().findFirst().get().getName()).isEqualTo("LTE 프리미어 플러스");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void findPlanById() {
        //given
        Long planId = 1L;

        try {
            //when
            PlanResDto planDetail = planService.findOne(planId);

            //then
            Assertions.assertThat(planDetail).isNotNull();
            Assertions.assertThat(planDetail.getName()).isEqualTo("5G 시그니처");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
