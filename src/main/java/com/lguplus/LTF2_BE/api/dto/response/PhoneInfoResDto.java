package com.lguplus.LTF2_BE.api.dto.response;

import com.lguplus.LTF2_BE.core.domain.Color;
import com.lguplus.LTF2_BE.core.domain.PhoneColor;
import com.lguplus.LTF2_BE.core.domain.PhoneInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class PhoneInfoResDto {

    private Long phoneInfoId;

    private String cpu;

    private String display;

    private String size;

    private String weight;

    private String camera;

    private String memory;

    private String storage;

    private String waterproof;

    private List<String> colorList;

    public PhoneInfoResDto(PhoneInfo phoneInfo) {
        phoneInfoId = phoneInfo.getId();
        cpu = phoneInfo.getCpu();
        display = phoneInfo.getDisplay();
        size = phoneInfo.getSize();
        weight = phoneInfo.getWeight();
        camera = phoneInfo.getCamera();
        memory = phoneInfo.getMemory();
        storage = phoneInfo.getStorage();
        waterproof = phoneInfo.getWaterproof();
        colorList = phoneInfo.getPhone().getPhoneColors()
                .stream().map(PhoneColor::getColor).collect(Collectors.toList())
                .stream().map(Color::getName).collect(Collectors.toList());
    }
}
