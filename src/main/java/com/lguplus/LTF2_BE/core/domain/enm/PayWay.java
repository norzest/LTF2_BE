package com.lguplus.LTF2_BE.core.domain.enm;

import lombok.Getter;

// writer : 최강현
@Getter
public enum PayWay {

    CARD(1, "신용 카드"),
    ACCOUNT(2, "계좌 이체");

    private Integer code;
    private String value;

    PayWay(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    // writer : 심영효
    public static PayWay convertValue(String payWay) {
        PayWay result = null;

        switch (payWay) {
            case "신용 카드":
                result = PayWay.CARD;
                break;
            case  "계좌 이체":
                result = PayWay.ACCOUNT;
                break;
            default:
                break;
        }

        return result;
    }
}
