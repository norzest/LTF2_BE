package com.lguplus.LTF2_BE;

import com.lguplus.LTF2_BE.api.dto.response.PhoneDetailResDto;
import com.lguplus.LTF2_BE.api.dto.response.PhoneResDto;
import com.lguplus.LTF2_BE.api.service.PhoneService;
import com.lguplus.LTF2_BE.core.domain.Phone;
import com.lguplus.LTF2_BE.core.repository.PhoneRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class PhoneServiceTest {

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private PhoneRepository phoneRepository;

    @BeforeEach
    void before() {
        getPhone();
    }

    private Phone phone;

    @Test
    public void findPhonesTest() {
        // when
        List<PhoneResDto> phones = phoneService.findPhones();

        // then
        Assertions.assertThat(phones).isNotNull();
        Assertions.assertThat(phones.size()).isEqualTo(28);
        Assertions.assertThat(phones.stream().findFirst().get().getTitleName()).isEqualTo("갤럭시 Z Flip 4");
        Assertions.assertThat(phones.stream().findFirst().get().getModel()).isEqualTo("SM-F721N");
        Assertions.assertThat(phones.stream().findFirst().get().getPhoneInfo().getPhoneInfoId()).isEqualTo(1l);
        Assertions.assertThat(phones.stream().findFirst().get().getColorList().size()).isEqualTo(4);
    }

    @Test
    public void findPhonesByTelecomTechTest() {
        // given
        String telecomTech5G = "5G";
        String telecomTech4G = "LTE";

        // when
        List<PhoneResDto> phones5G = phoneService.findPhonesByTelecomTech(telecomTech5G);
        List<PhoneResDto> phones4G = phoneService.findPhonesByTelecomTech(telecomTech4G);

        // then
        Assertions.assertThat(phones5G).isNotNull();
        Assertions.assertThat(phones5G.stream().findFirst().get().getTitleName()).isEqualTo("갤럭시 Z Flip 4");
        Assertions.assertThat(phones5G.stream().findFirst().get().getModel()).isEqualTo("SM-F721N");
        Assertions.assertThat(phones5G.stream().findFirst().get().getPhoneInfo().getPhoneInfoId()).isEqualTo(1l);
        Assertions.assertThat(phones5G.stream().findFirst().get().getColorList().size()).isEqualTo(4);
        Assertions.assertThat(phones4G).isNotNull();
        Assertions.assertThat(phones4G.stream().findFirst().get().getTitleName()).isEqualTo("Galaxy A13");
        Assertions.assertThat(phones4G.stream().findFirst().get().getModel()).isEqualTo("SM-A135N");
        Assertions.assertThat(phones4G.stream().findFirst().get().getPhoneInfo().getPhoneInfoId()).isEqualTo(21l);
        Assertions.assertThat(phones4G.stream().findFirst().get().getColorList().size()).isEqualTo(2);
    }

    @Test
    public void findPhonesByTelecomTechExceptionTest() {
        // given
        String telecomTech4G = "4G";

        // then
        Exception exception = assertThrows(Exception.class, () -> {
            phoneService.findPhonesByTelecomTech(telecomTech4G);
        });
        assertEquals(NoSuchElementException.class, exception.getClass());
    }

    @Test
    public void findPhoneDetailTest() {
        // given
        Long phoneId = phone.getId();

        // when
        PhoneDetailResDto phoneDetail = phoneService.findPhoneDetail(phoneId);

        // then
        Assertions.assertThat(phoneDetail).isNotNull();
        Assertions.assertThat(phoneDetail.getPhoneId()).isEqualTo(1l);
        Assertions.assertThat(phoneDetail.getTitleName()).isEqualTo("갤럭시 Z Flip 4");
        Assertions.assertThat(phoneDetail.getModel()).isEqualTo("SM-F721N");
        Assertions.assertThat(phoneDetail.getPhoneInfo().getPhoneInfoId()).isEqualTo(1l);
        Assertions.assertThat(phoneDetail.getColorList().size()).isEqualTo(4);
        Assertions.assertThat(phoneDetail.getTelecomTech()).isEqualTo("5G");
    }

    @Test
    public void findPhoneDetailExceptionTest() {
        // given
        Long phoneExceptionId = 1000l;

        // then
        Exception exception = assertThrows(Exception.class, () -> {
            phoneService.findPhoneDetail(phoneExceptionId);
        });
        assertEquals(NoSuchElementException.class, exception.getClass());
    }

    private void getPhone() {
        phone = phoneRepository.findById(1l).get();
    }
}
