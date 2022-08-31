package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.request.OrdersReqDto;

public interface OrdersService {

    // 상품을 주문하는 함수
    Long createOrder(OrdersReqDto ordersReqDto);
}
