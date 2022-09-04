package com.lguplus.LTF2_BE;

import com.lguplus.LTF2_BE.api.dto.request.OrdersReqDto;
import com.lguplus.LTF2_BE.api.service.OrdersService;
import com.lguplus.LTF2_BE.core.domain.Orders;
import com.lguplus.LTF2_BE.core.repository.OrdersRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// writer : 최강현
@SpringBootTest
@Transactional
public class OrdersServiceTest {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrdersRepository ordersRepository;

    @Test
    public void createOrderTest() {
        // given
        OrdersReqDto ordersReqDto = new OrdersReqDto(1l, 1l, 2l, "오늘 도착", "내국인", "홍길동",
                "01012341234", "01012341234", "hong@naver.com", "서울 마포구 월드컵북로 416", "문자 메세지", "신용 카드");

        // when
        Long orderId = ordersService.createOrder(ordersReqDto);
        Orders order = ordersRepository.findById(orderId).orElse(null);

        // then
        Assertions.assertThat(order).isNotNull();
        Assertions.assertThat(order.getDeliveryType().getValue()).isEqualTo("오늘 도착");
        Assertions.assertThat(order.getCustomerName()).isEqualTo("홍길동");
        Assertions.assertThat(order.getAblePhoneNumber()).isEqualTo("01012341234");
        Assertions.assertThat(order.getCustomerEmail()).isEqualTo("hong@naver.com");
    }

    @Test
    public void createOrderExceptionTest() {
        // given
        Long phoneExceptionId = 1000l;
        String converterExceptionName = "신용 카드드";
        OrdersReqDto ordersPhoneIdExceptionReqDto = new OrdersReqDto(phoneExceptionId, 1l, 2l, "오늘 도착", "내국인", "홍길동",
                "01012341234", "01012341234", "hong@naver.com", "서울 마포구 월드컵북로 416", "문자 메세지", "신용 카드");
        OrdersReqDto ordersConverterExceptionReqDto = new OrdersReqDto(phoneExceptionId, 1l, 2l, "오늘 도착", "내국인", "홍길동",
                "01012341234", "01012341234", "hong@naver.com", "서울 마포구 월드컵북로 416", "문자 메세지", converterExceptionName);

        // then
        Exception exception1 = assertThrows(Exception.class, () -> {
            ordersService.createOrder(ordersPhoneIdExceptionReqDto);
        });
        assertEquals(NullPointerException.class, exception1.getClass());

        Exception exception2 = assertThrows(Exception.class, () -> {
            ordersService.createOrder(ordersConverterExceptionReqDto);
        });
        assertEquals(NullPointerException.class, exception2.getClass());
    }
}
