package com.lguplus.LTF2_BE.api.util.converter;

import com.lguplus.LTF2_BE.core.domain.enm.DeliveryType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.EnumSet;
import java.util.NoSuchElementException;

@Converter
public class DeliveryTypeConverter implements AttributeConverter<DeliveryType, Integer> {
    
    // int 값으로 변환 후 DB에 저장
    @Override
    public Integer convertToDatabaseColumn(DeliveryType attribute) {
        return attribute.getCode();
    }

    // DB 값을 문자열로 변환해서 불러오기
    @Override
    public DeliveryType convertToEntityAttribute(Integer dbData) {
        return EnumSet.allOf(DeliveryType.class).stream()
                .filter(e -> e.getCode().equals(dbData))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
