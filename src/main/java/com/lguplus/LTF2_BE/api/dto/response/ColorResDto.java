package com.lguplus.LTF2_BE.api.dto.response;

import com.lguplus.LTF2_BE.core.domain.Color;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ColorResDto {

    private Long colorId;

    private String name;

    private String hexCode;

    public ColorResDto(Color color) {
        colorId = color.getId();
        name = color.getName();
        hexCode = color.getHexCode();
    }
}
