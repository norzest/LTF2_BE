package com.lguplus.LTF2_BE.core.domain;

import lombok.Getter;

@Getter
public enum TelecomTech {
    G3(1, "3G"),
    LTE(2, "LTE"),
    G5(3, "5G");

    private Integer code;
    private String value;

    TelecomTech(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
