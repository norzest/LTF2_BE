package com.lguplus.LTF2_BE.api.dto.response;


import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class PlanResDto {

    private Long id;

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


}
