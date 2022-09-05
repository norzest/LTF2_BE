package com.lguplus.LTF2_BE;

import com.lguplus.LTF2_BE.api.dto.response.ShoppingBasketResDto;
import com.lguplus.LTF2_BE.api.service.ShoppingBasketService;
import com.lguplus.LTF2_BE.core.domain.Color;
import com.lguplus.LTF2_BE.core.domain.Phone;
import com.lguplus.LTF2_BE.core.domain.Plan;
import com.lguplus.LTF2_BE.core.repository.ColorRepository;
import com.lguplus.LTF2_BE.core.repository.PhoneRepository;
import com.lguplus.LTF2_BE.core.repository.PlanRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// writer : 권혁준
@SpringBootTest
@Transactional
public class ShoppingBasketServiceTest {

    @Autowired
    private ShoppingBasketService shoppingBasketService;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private ColorRepository colorRepository;

    @BeforeEach
    void before() {
        getPhone();
        getPlan();
        getColor();
    }

    private Phone phone;
    private Plan plan;
    private Color color;

    @Test
    public void findShoppingBasketTest() {
        // given
        Long phoneId = phone.getId();
        Long planId = plan.getId();
        Long colorId = color.getId();

        // when
        ShoppingBasketResDto shoppingBasket = shoppingBasketService.findShoppingBasket(phoneId, planId, colorId);

        // then
        Assertions.assertThat(shoppingBasket).isNotNull();
        Assertions.assertThat(shoppingBasket.getTitleName()).isEqualTo("갤럭시 Z Flip 4");
        Assertions.assertThat(shoppingBasket.getPhoneImgList().size()).isEqualTo(4);
        Assertions.assertThat(shoppingBasket.getColorName()).isEqualTo("블루");
        Assertions.assertThat(shoppingBasket.getSupportPrice()).isEqualTo(575000);
    }

    @Test
    public void findShoppingBasketExceptionTest() {
        // given
        Long phoneId = phone.getId();
        Long planId = plan.getId();
        Long exceptionColorId = 1000l;

        // then
        Exception exception = assertThrows(Exception.class, () -> {
            shoppingBasketService.findShoppingBasket(phoneId, planId, exceptionColorId);
        });
        assertEquals("No value present", exception.getMessage());
    }

    private void getPhone() {
        phone = phoneRepository.findById(1l).get();
    }

    private void getPlan() {
        plan = planRepository.findById(1l).get();
    }

    private void getColor() {
        color = colorRepository.findById(2l).get();
    }
}