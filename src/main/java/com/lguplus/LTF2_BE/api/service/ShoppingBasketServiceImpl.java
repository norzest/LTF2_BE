package com.lguplus.LTF2_BE.api.service;

import com.lguplus.LTF2_BE.api.dto.response.ShoppingBasketResDto;
import com.lguplus.LTF2_BE.core.domain.*;
import com.lguplus.LTF2_BE.core.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ShoppingBasketServiceImpl implements ShoppingBasketService{

    private final PhoneRepository phoneRepository;
    private final PlanRepository planRepository;
    private final ColorRepository colorRepository;
    private final PhoneColorRepository phoneColorRepository;
    private final PublicSupportRepository publicSupportRepository;

    @Override
    public ShoppingBasketResDto findShoppingBasket(Long phoneId, Long planId, Long colorId) {
        Phone phone = phoneRepository.findById(phoneId).get();
        Plan plan = planRepository.findById(planId).get();
        Color color = colorRepository.findById(colorId).get();
        PhoneColor phoneColor = phoneColorRepository.findByPhoneIdAndColorId(phoneId, colorId);
        List<String> phoneImgList = phoneColor.getPhoneImgs()
                .stream().map(PhoneImg::getImg).collect(Collectors.toList());
        Integer supportPrice = publicSupportRepository.findByPhoneIdAndPlanId(phoneId, planId).getSupportPrice();

        return new ShoppingBasketResDto(phone, plan, color, phoneImgList, supportPrice);
    }
}