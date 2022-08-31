package com.lguplus.LTF2_BE.core.domain.enm;

import lombok.Getter;

@Getter
public enum BillAcceptWay {

    MESSAGE(1, "문자 메세지"),
    EMAIL(2, "이메일");

    private Integer code;
    private String value;


    BillAcceptWay(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static BillAcceptWay convertValue(String billAcceptWay) {
        BillAcceptWay result = null;

        switch (billAcceptWay) {
            case "문자 메세지":
                result = BillAcceptWay.MESSAGE;
                break;
            case "이메일":
                result = BillAcceptWay.EMAIL;
                break;
            default:
                break;
        }

        return result;
    }
}
