package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.response.ShoppingBasketResDto;

public interface ShoppingBasketService {

    ShoppingBasketResDto findShoppingBasket(Long phoneId, Long planId, Long colorId);
}