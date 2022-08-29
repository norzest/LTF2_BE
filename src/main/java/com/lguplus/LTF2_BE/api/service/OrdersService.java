package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.request.OrdersReqDto;

public interface OrdersService {

    Long createOrder(OrdersReqDto ordersReqDto);
}
