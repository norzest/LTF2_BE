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

        Phone phone = phoneRepository.findById(ordersReqDto.getPhoneId()).get();
        Plan plan = planRepository.findById(ordersReqDto.getPlanId()).get();
        Color color = colorRepository.findById(ordersReqDto.getColorId()).get();

        Orders order = Orders.builder()
                .phone(phone)
                .plan(plan)
                .color(color)
                .deliveryType(ordersReqDto.getDeliveryType())
                .customerType(ordersReqDto.getCustomerType())
                .customerName(ordersReqDto.getCustomerName())
                .changePhoneNumber(ordersReqDto.getChangePhoneNumber())
                .ablePhoneNumber(ordersReqDto.getAblePhoneNumber())
                .customerEmail(ordersReqDto.getCustomerEmail())
                .customerAddress(ordersReqDto.getCustomerAddress())
                .billAcceptWay(ordersReqDto.getBillAcceptWay())
                .payWay(ordersReqDto.getPayWay())
                .build();

        Orders saveOrder = ordersRepository.save(order);

        return saveOrder.getId();
    }
}
