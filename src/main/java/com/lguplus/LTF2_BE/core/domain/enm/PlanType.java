package com.lguplus.LTF2_BE.core.domain.enm;

import lombok.Getter;

// writer : 심영효
@Getter
public enum PlanType {
    BASIC(1, "데이터 일반"),
    UNLIMITED(2, "데이터 무제한"),
    TEENAGER(3, "청소년"),
    SENIOR(4, "시니어"),
    DIRECT(5, "다이렉트"),
    WELFARE(6, "복지"),
    SOLDIER(7, "현역병사");

    private Integer code;
    private String value;

    PlanType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static PlanType convertValue(String planType) {
        PlanType result = null;

        switch (planType) {
            case "데이터 일반":
                result = PlanType.BASIC;
                break;
            case "데이터 무제한":
                result = PlanType.UNLIMITED;
                break;
            case "청소년":
                result = PlanType.TEENAGER;
                break;
            case "시니어":
                result = PlanType.SENIOR;
                break;
            case "다이렉트":
                result = PlanType.DIRECT;
                break;
            case "복지":
                result = PlanType.WELFARE;
                break;
            case "현역병사":
                result = PlanType.SOLDIER;
                break;
            default:
                break;
        }

        return result;
    }
}
