package com.lguplus.LTF2_BE.core.domain.enm;

import lombok.Getter;

// writer : 심영효
@Getter
public enum DeliveryType {
    POSTOFFICE(1, "우체국 택배"),
    SAMEDAY(2, "오늘 도착");

    private Integer code;
    private String value;

    DeliveryType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    // writer : 심영효
    public static DeliveryType convertValue(String deliveryType) {
        DeliveryType result = null;

        switch (deliveryType) {
            case "우체국 택배":
                result = DeliveryType.POSTOFFICE;
                break;
            case "오늘 도착":
                result = DeliveryType.SAMEDAY;
                break;
            default:
                break;
        }

        return result;
    }
}
