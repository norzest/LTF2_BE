package com.lguplus.LTF2_BE.api.dto.request;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersReqDto {

    @NotNull
    @ApiModelProperty(value = "핸드폰 id", required = true, example = "1")
    private Long phoneId;

    @NotNull
    @ApiModelProperty(value = "요금제 id", required = true, example = "1")
    private Long planId;

    @NotNull
    @ApiModelProperty(value = "색깔 id", required = true, example = "1")
    private Long colorId;

    @NotNull
    @ApiModelProperty(value = "배송방법", required = true, example = "오늘 도착")
    private String deliveryType;

    @NotNull
    @ApiModelProperty(value = "소비자 유형", required = true, example = "내국인")
    private String userType;

    @NotNull
    @ApiModelProperty(value = "소비자 이름", required = true, example = "홍길동")
    private String userName;

    @NotNull
    @ApiModelProperty(value = "기기 변경 핸드폰 번호", required = true, example = "01012341234")
    private String userPhone;

    @NotNull
    @ApiModelProperty(value = "연락 가능한 전화번호", required = true, example = "01012341234")
    private String ablePhone;

    @NotNull
    @ApiModelProperty(value = "소비자 이메일", required = true, example = "hong@naver.com")
    private String email;

    @NotNull
    @ApiModelProperty(value = "소비자 주소", required = true, example = "서울 마포구 월드컵북로 416")
    private String address;

    @NotNull
    @ApiModelProperty(value = "청구서 받는 방법", required = true, example = "문자 메세지")
    private String billType;

    @NotNull
    @ApiModelProperty(value = "요금 납부 방법", required = true, example = "신용 카드")
    private String payType;
}
