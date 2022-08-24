package com.lguplus.LTF2_BE.core.domain;

import lombok.Getter;

@Getter
public enum MediaService {
    MOVIE(1, "U+영화월정액"),
    GENIEPC(2, "지니뮤직(모바일+PC)"),
    GENIEAPP(3, "지니뮤직 APP 음악감상"),
    GENIE300(4, "지니 300회"),
    IDLELIB(5, "U+아이들생생도서관"),
    MILLILIB(6, "밀리의 서재");

    private Integer code;
    private String value;

    MediaService(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static MediaService convertValue(String mediaService) {
        MediaService result = null;

        switch (mediaService) {
            case "U+영화월정액":
                result = MediaService.MOVIE;
                break;
            case "지니뮤직(모바일+PC)":
                result = MediaService.GENIEPC;
                break;
            case "지니뮤직 APP 음악감상":
                result = MediaService.GENIEAPP;
                break;
            case "지니 300회":
                result = MediaService.GENIE300;
                break;
            case "U+아이들생생도서관":
                result = MediaService.IDLELIB;
                break;
            case "밀리의 서재":
                result = MediaService.MILLILIB;
                break;
            default:
                break;
        }

        return result;
    }
}
