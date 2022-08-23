package com.lguplus.LTF2_BE.core.domain;

import lombok.Getter;

@Getter
public enum OrderPlan {
    POSTOFFICE("1", "우체국 택배"),
    SAMEDAY("2", "오늘 도착");

    private String code;
    private String value;

    OrderPlan(String code, String value) {
        this.code = code;
        this.value = value;
    }
}
