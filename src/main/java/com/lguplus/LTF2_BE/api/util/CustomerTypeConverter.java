package com.lguplus.LTF2_BE.api.util;

import com.lguplus.LTF2_BE.core.domain.CustomerType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.EnumSet;
import java.util.NoSuchElementException;

@Converter
public class CustomerTypeConverter implements AttributeConverter<CustomerType, Integer> {

    // int 값으로 변환 후 DB에 저장
    @Override
    public Integer convertToDatabaseColumn(CustomerType attribute) {
        return attribute.getCode();
    }

    // DB 값을 문자열로 변환해서 불러오기
    @Override
    public CustomerType convertToEntityAttribute(Integer dbData) {
        return EnumSet.allOf(CustomerType.class).stream()
                .filter(e -> e.getCode().equals(dbData))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
