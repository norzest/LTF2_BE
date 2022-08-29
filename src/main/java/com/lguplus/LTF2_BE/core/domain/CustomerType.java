package com.lguplus.LTF2_BE.core.domain;

public enum CustomerType {

    LOCAL(1, "내국인"),
    FOREIGNER(2, "외국인");

    private Integer code;
    private String value;

    CustomerType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
