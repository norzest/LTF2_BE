package com.lguplus.LTF2_BE.core.domain;

public enum PayWay {

    CARD(1, "신용 카드"),
    ACCOUNT(2, "계좌 이체");

    private Integer code;
    private String value;

    PayWay(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
