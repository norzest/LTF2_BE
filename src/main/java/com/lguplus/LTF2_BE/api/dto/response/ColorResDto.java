package com.lguplus.LTF2_BE.api.dto.response;

import com.lguplus.LTF2_BE.core.domain.Color;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

// writer : 최강현
@Data
@NoArgsConstructor
public class ColorResDto {

    private Long colorId;

    private String name;

    private String hexCode;

    private List<String> phoneImgList;

    public ColorResDto(Color color) {
        colorId = color.getId();
        name = color.getName();
        hexCode = color.getHexCode();
        phoneImgList = new ArrayList<>();
    }

    public ColorResDto(Color color, List<String> phoneImgList) {
        colorId = color.getId();
        name = color.getName();
        hexCode = color.getHexCode();
        this.phoneImgList = phoneImgList;
    }
}
