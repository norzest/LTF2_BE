package com.lguplus.LTF2_BE.core.domain.enm;

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

    public static TelecomTech convertValue(String telecomTech) {
        TelecomTech result = null;

        switch (telecomTech) {
            case "5G":
                result = TelecomTech.G5;
                break;
            case "LTE":
                result = TelecomTech.LTE;
                break;
            case "3G":
                result = TelecomTech.G3;
                break;
            default:
                break;
        }

        return result;
    }
}
