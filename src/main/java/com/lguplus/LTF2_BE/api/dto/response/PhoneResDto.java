package com.lguplus.LTF2_BE.api.dto.response;

import com.lguplus.LTF2_BE.core.domain.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class PhoneResDto {

    private Long phoneId;

    private String titleName;

    private String titleSub;

    private String model;

    private Integer price;

    private String previewImg;

    private String manufacturingCompany;

    private String telecomTech;

    private PhoneInfoResDto phoneInfo;

    private List<ColorResDto> colorList;

    public PhoneResDto(Phone phone) {
        phoneId = phone.getId();
        titleName = phone.getTitleName();
        titleSub = phone.getTitleSub();
        model = phone.getModel();
        price = phone.getPrice();
        previewImg = phone.getPreviewImg();
        manufacturingCompany = phone.getManufacturingCompany().getValue();
        telecomTech = phone.getTelecomTech().getValue();
        phoneInfo = new PhoneInfoResDto(phone.getPhoneInfo());
        colorList = phone.getPhoneColors()
                .stream().map(PhoneColor::getColor).collect(Collectors.toList())
                .stream().map(ColorResDto::new).collect(Collectors.toList());
    }
}
