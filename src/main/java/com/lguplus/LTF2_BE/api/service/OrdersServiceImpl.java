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

        Phone phone = phoneRepository.findById(ordersReqDto.getPhoneId()).orElse(null);
        Plan plan = planRepository.findById(ordersReqDto.getPlanId()).orElse(null);
        Color color = colorRepository.findById(ordersReqDto.getColorId()).orElse(null);

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
        Orders saveOrder = ordersRepository.save(order);

        return saveOrder.getId();
    }
}
