package com.lguplus.LTF2_BE.api.util;

import com.lguplus.LTF2_BE.core.domain.MediaService;
import com.lguplus.LTF2_BE.core.domain.OrderPlan;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;
import java.util.NoSuchElementException;

public class MediaServiceConverter implements AttributeConverter<MediaService, String> {

    // int 값으로 변환 후 DB에 저장
    @Override
    public String convertToDatabaseColumn(MediaService attribute) {
        return attribute.getCode();
    }

    // DB 값을 문자열로 변환해서 불러오기
    @Override
    public MediaService convertToEntityAttribute(String dbData) {
        return EnumSet.allOf(MediaService.class).stream()
                .filter(e -> e.getCode().equals(dbData))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
