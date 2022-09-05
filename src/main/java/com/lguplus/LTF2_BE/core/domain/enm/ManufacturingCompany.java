package com.lguplus.LTF2_BE.core.domain.enm;

import lombok.Getter;

@Getter
public enum ManufacturingCompany {
    OTHER(1, "기타"),
    SAMSUNG(2, "삼성"),
    APPLE(3, "애플");

    private Integer code;
    private String value;

    ManufacturingCompany(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static ManufacturingCompany convertValue (String manufacturingCompany) {
        ManufacturingCompany result = null;

        switch (manufacturingCompany) {
            case "기타":
                result = ManufacturingCompany.OTHER;
                break;
            case "삼성":
                result = ManufacturingCompany.SAMSUNG;
                break;
            case "애플":
                result = ManufacturingCompany.APPLE;
                break;
            default:
                break;
        }

        return result;
    }
}