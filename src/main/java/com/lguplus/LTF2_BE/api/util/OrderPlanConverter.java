package com.lguplus.LTF2_BE.api.util;

import com.lguplus.LTF2_BE.core.domain.OrderPlan;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;
import java.util.NoSuchElementException;

public class OrderPlanConverter implements AttributeConverter<OrderPlan, Integer> {
    
    // int 값으로 변환 후 DB에 저장
    @Override
    public Integer convertToDatabaseColumn(OrderPlan attribute) {
        return attribute.getCode();
    }

    // DB 값을 문자열로 변환해서 불러오기
    @Override
    public OrderPlan convertToEntityAttribute(Integer dbData) {
        return EnumSet.allOf(OrderPlan.class).stream()
                .filter(e -> e.getCode().equals(dbData))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
