package com.lguplus.LTF2_BE.core.domain;

import lombok.Getter;

@Getter
public enum ManuFacturingCompany {
    OTHER(1, "기타"),
    SAMSUNG(2, "삼성"),
    APPLE(3, "애플");

    private Integer code;
    private String value;

    ManuFacturingCompany(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
