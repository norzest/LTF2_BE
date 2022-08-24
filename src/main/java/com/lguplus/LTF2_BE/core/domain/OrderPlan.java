package com.lguplus.LTF2_BE.core.domain;

import lombok.Getter;

@Getter
public enum OrderPlan {
    POSTOFFICE(1, "우체국 택배"),
    SAMEDAY(2, "오늘 도착");

    private Integer code;
    private String value;

    OrderPlan(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static OrderPlan convertValue(String orderPlan) {
        OrderPlan result = null;

        switch (orderPlan) {
            case "우체국 택배":
                result = OrderPlan.POSTOFFICE;
                break;
            case "오늘 도착":
                result = OrderPlan.SAMEDAY;
                break;
            default:
                break;
        }

        return result;
    }
}
