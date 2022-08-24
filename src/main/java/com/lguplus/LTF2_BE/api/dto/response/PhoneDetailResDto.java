package com.lguplus.LTF2_BE.api.dto.response;

import com.lguplus.LTF2_BE.core.domain.Phone;
import com.lguplus.LTF2_BE.core.domain.PhoneColor;
import com.lguplus.LTF2_BE.core.domain.PhoneDesImg;
import com.lguplus.LTF2_BE.core.domain.PhoneImg;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class PhoneDetailResDto {

    private Long phoneId;

    private String titleName;

    private String model;

    private Integer price;

    private String manufacturingCompany;

    private String telecomTech;

    private PhoneInfoResDto phoneInfo;

    private List<String> phoneDesImgList;

    private List<ColorResDto> colorList;

    public PhoneDetailResDto(Phone phone, List<ColorResDto> colorList) {
        phoneId = phone.getId();
        titleName = phone.getTitleName();
        model = phone.getModel();
        price = phone.getPrice();
        manufacturingCompany = phone.getManufacturingCompany().getValue();
        telecomTech = phone.getTelecomTech().getValue();
        phoneInfo = new PhoneInfoResDto(phone.getPhoneInfo());
        phoneDesImgList = phone.getPhoneDesImgs()
                .stream().map(PhoneDesImg::getImg).collect(Collectors.toList());
        this.colorList = colorList;
    }
}
