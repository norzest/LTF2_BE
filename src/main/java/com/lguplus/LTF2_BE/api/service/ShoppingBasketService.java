package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.response.ShoppingBasketResDto;

// writer : 권혁준
public interface ShoppingBasketService {

    // 장바구니 데이터를 조회하는 함수
    ShoppingBasketResDto findShoppingBasket(Long phoneId, Long planId, Long colorId);
}