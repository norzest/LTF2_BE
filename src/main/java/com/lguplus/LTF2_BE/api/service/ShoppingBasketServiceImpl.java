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

    // 장바구니 데이터를 조회하는 함수
    @Override
    public ShoppingBasketResDto findShoppingBasket(Long phoneId, Long planId, Long colorId) {

        // phoneId, planId, colorId를 통해 DB에서 Phone, Plan, Color 객체 반환
        Phone phone = phoneRepository.findById(phoneId).get();
        Plan plan = planRepository.findById(planId).get();
        Color color = colorRepository.findById(colorId).get();
        // phoneId, colorId를 통해 DB에서 PhoneColor 객체 반환
        PhoneColor phoneColor = phoneColorRepository.findByPhoneIdAndColorId(phoneId, colorId);
        /**
         * PhoneColor 객체에 대응되는 phoneImgList 조회하여
         * List<PhoneImg>을 List<String>으로 변환하여 반환
         */
        List<String> phoneImgList = phoneColor.getPhoneImgs()
                .stream().map(PhoneImg::getImg).collect(Collectors.toList());
        // phoneId, planId를 통해 DB에서 SupportPrice 객체 반환후 공시지원금 가격 저장
        Integer supportPrice = publicSupportRepository.findByPhoneIdAndPlanId(phoneId, planId).getSupportPrice();
        // ShoppingBasketResDto 객체를 생성하여 반환
        return new ShoppingBasketResDto(phone, plan, color, phoneImgList, supportPrice);
    }
}