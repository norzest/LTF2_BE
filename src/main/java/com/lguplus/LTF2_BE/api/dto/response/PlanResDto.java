package com.lguplus.LTF2_BE.api.dto.response;


import com.lguplus.LTF2_BE.core.domain.enm.MediaService;
import com.lguplus.LTF2_BE.core.domain.Plan;
import com.lguplus.LTF2_BE.core.domain.PlanMediaService;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class PlanResDto {

    private Long planId;

    private String name;

    private Integer monthPrice;

    private String data;

    private String dataPlus;

    private String shareData;

    private String shareDataPlus;

    private String voice;

    private String voicePlus;

    private String message;

    private String smartDevice;

    private String smartDeviceDiscount;

    private String premiumService;

    private String basicBenefit;

    private String familySig5g;

    private String telecomTech;

    private String planType;

    private List<String> mediaServices;

    public PlanResDto(Plan plan) {
        planId = plan.getId();
        name = plan.getName();
        monthPrice = plan.getMonthPrice();
        data = plan.getData();
        dataPlus = plan.getDataPlus();
        shareData = plan.getShareData();
        shareDataPlus = plan.getShareDataPlus();
        voice = plan.getVoice();
        voicePlus = plan.getVoicePlus();
        message = plan.getMessage();
        smartDevice = plan.getSmartDevice();
        smartDeviceDiscount = plan.getSmartDeviceDiscount();
        premiumService = plan.getPremiumService();
        basicBenefit = plan.getBasicBenefit();
        familySig5g = plan.getFamilySig5g();
        telecomTech = plan.getTelecomTech().getValue();
        planType = plan.getPlanType().getValue();
        mediaServices = plan.getPlanMediaServices()
                .stream().map(PlanMediaService::getMediaService).collect(Collectors.toList())
                .stream().map(MediaService::getValue).collect(Collectors.toList());
    }
}
