package com.lguplus.LTF2_BE.core.domain;

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
}
