package com.lguplus.LTF2_BE.api.dto.response;

import com.lguplus.LTF2_BE.core.domain.Color;
import com.lguplus.LTF2_BE.core.domain.Phone;
import com.lguplus.LTF2_BE.core.domain.Plan;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ShoppingBasketResDto {

    private Long phoneId;

    private String titleName;

    private Integer phonePrice;

    private Integer memory;

    private List<String> phoneImgList;

    private Long planId;

    private String planName;

    private Integer planMonthPrice;

    private Long colorId;

    private String colorName;

    private String hexCode;

    private Integer supportPrice;

    public ShoppingBasketResDto(Phone phone, Plan plan, Color color, List<String> phoneImgList, Integer supportPrice) {
        phoneId = phone.getId();
        titleName = phone.getTitleName();
        phonePrice = phone.getPrice();
        memory = phone.getPhoneInfo().getMemory();
        this.phoneImgList = phoneImgList;
        planId = plan.getId();
        planName = plan.getName();
        planMonthPrice = plan.getMonthPrice();
        colorId = color.getId();
        colorName = color.getName();
        hexCode = color.getHexCode();
        this.supportPrice = supportPrice;
    }
}