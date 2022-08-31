package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.request.OrdersReqDto;
import com.lguplus.LTF2_BE.core.domain.Color;
import com.lguplus.LTF2_BE.core.domain.Orders;
import com.lguplus.LTF2_BE.core.domain.Phone;
import com.lguplus.LTF2_BE.core.domain.Plan;
import com.lguplus.LTF2_BE.core.repository.ColorRepository;
import com.lguplus.LTF2_BE.core.repository.OrdersRepository;
import com.lguplus.LTF2_BE.core.repository.PhoneRepository;
import com.lguplus.LTF2_BE.core.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrdersServiceImpl implements OrdersService{

    private final OrdersRepository ordersRepository;
    private final PhoneRepository phoneRepository;
    private final PlanRepository planRepository;
    private final ColorRepository colorRepository;

    @Override
    public Long createOrder(OrdersReqDto ordersReqDto) {

        /**
         * Orders 객체를 생성하기 위해
         * DB에서 phone, plan, color를 조회하여 각각의 객체 반환
         * DB에 해당 id가 존재하지 않을 경우 NullPointerException 발생
         */
        Phone phone = phoneRepository.findById(ordersReqDto.getPhoneId())
                .orElseThrow(() -> new NullPointerException());
        Plan plan = planRepository.findById(ordersReqDto.getPlanId())
                .orElseThrow(() -> new NullPointerException());
        Color color = colorRepository.findById(ordersReqDto.getColorId())
                .orElseThrow(() -> new NullPointerException());

        /**
         * Orders 객체를 생성하기 위해 builder 패턴 활용
         * phone, plan, color, ordersReqDto 정보를 활용하여 Orders 객체 생성
         */
        Orders order = Orders.builder()
                .phone(phone)
                .plan(plan)
                .color(color)
                .deliveryType(ordersReqDto.getDeliveryType())
                .customerType(ordersReqDto.getUserType())
                .customerName(ordersReqDto.getUserName())
                .changePhoneNumber(ordersReqDto.getUserPhone())
                .ablePhoneNumber(ordersReqDto.getAblePhone())
                .customerEmail(ordersReqDto.getEmail())
                .customerAddress(ordersReqDto.getAddress())
                .billAcceptWay(ordersReqDto.getBillType())
                .payWay(ordersReqDto.getPayType())
                .build();
        // DB에 order 등록 후, 등록한 Orders 객체 반환
        Orders saveOrder = ordersRepository.save(order);

        // saveOrder의 id 반환
        return saveOrder.getId();
    }
}
