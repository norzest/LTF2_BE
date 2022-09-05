package com.lguplus.LTF2_BE.core.domain.enm;

import lombok.Getter;

// writer : 최강현
@Getter
public enum CustomerType {

    LOCAL(1, "내국인"),
    FOREIGNER(2, "외국인");

    private Integer code;
    private String value;

    CustomerType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    // writer : 심영효
    public static CustomerType convertValue (String customerType) {
        CustomerType result = null;

        switch (customerType) {
            case "내국인":
                result = CustomerType.LOCAL;
                break;
            case "외국인":
                result = CustomerType.FOREIGNER;
                break;
            default:
                break;
        }

        return result;
    }
}
