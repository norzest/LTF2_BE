package com.lguplus.LTF2_BE.api.controller;

import com.lguplus.LTF2_BE.api.dto.response.PublicSupportPhoneResDto;
import com.lguplus.LTF2_BE.api.dto.response.PublicSupportPlanResDto;
import com.lguplus.LTF2_BE.api.service.PublicSupportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "PublicSupport", value = "공시지원금 API")
@RestController
@RequestMapping("/public-support")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PublicSupportController {

    private final PublicSupportService publicSupportService;

    @GetMapping("/phone/{phone_id}")
    @ApiOperation(value = "핸드폰 공시지원금 조회", notes = "핸드폰에 맞는 공시지원금 조회.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 404, message = "해당 핸드폰의 공시지원금을 찾을 수 없습니다."),
            @ApiResponse(code = 500, message = "네트워크가 정상적이지 않습니다. 다시 시도해주세요."),

    })
    public ResponseEntity<Map<String,Object>> findPublicSupportPlan(@PathVariable(value = "phone_id") Long phoneId){
        Map<String, Object> resultMap = new HashMap<>();
        List<PublicSupportPlanResDto> publicSupportPhoneResList = null;
        HttpStatus status = null;

        try {
            // 핸드폰에 맞는 공시지원금 조회를 위해 publicSupportService의 findPublicSupportPlanRes() 함수 호출
            publicSupportPhoneResList = publicSupportService.findPublicSupportPlanResDto(phoneId);
            // 요금제에 따른 공시지원금 리스트가 있을 경우 PlanList 반환
            status = HttpStatus.OK;
            resultMap.put("PlanList",publicSupportPhoneResList);
        } catch (Exception e) {
            // Exception 발생 시 404 error 응답
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<Map<String,Object>>(resultMap, status);
    }

    @GetMapping("/plan/{plan_id}")
    @ApiOperation(value = "요금제 공시지원금 조회", notes = "요금제에 맞는 공시지원금 조회.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 404, message = "해당 요금제의 공시지원금을 찾을 수 없습니다."),
            @ApiResponse(code = 500, message = "네트워크가 정상적이지 않습니다. 다시 시도해주세요."),

    })
    public ResponseEntity<Map<String,Object>> findPublicSupportPhone(@PathVariable(value = "plan_id") Long planId){
        Map<String, Object> resultMap = new HashMap<>();
        List<PublicSupportPhoneResDto> publicSupportPhoneResList = null;
        HttpStatus status = null;

        try {
            // 요금제에 맞는 공시지원금 조회를 위해 publicSupportService의 findPublicSupportPhoneResDto() 함수 호출
            publicSupportPhoneResList = publicSupportService.findPublicSupportPhoneResDto(planId);
            // 핸드폰에 따른 공시지원금 리스트가 있을 경우 PhoneList 반환
            status = HttpStatus.OK;
            resultMap.put("PhoneList",publicSupportPhoneResList);
        } catch (Exception e) {
            // Exception 발생 시 404 error 응답
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<Map<String,Object>>(resultMap, status);
    }

    @GetMapping("/phone/{phone_id}/plan/{plan_id}")
    @ApiOperation(value = "핸드폰,요금제 공시지원금 조회", notes = "핸드폰,요금제에 맞는 공시지원금 조회.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 404, message = "해당 상품의 공시지원금을 찾을 수 없습니다."),
            @ApiResponse(code = 500, message = "네트워크가 정상적이지 않습니다. 다시 시도해주세요."),

    })
    public ResponseEntity<Map<String,Object>> findPublicSupportPrice(@PathVariable(value = "phone_id") Long phoneId, @PathVariable(value = "plan_id") Long planId){
        Map<String, Object> resultMap = new HashMap<>();
        Integer publicSupportPrice = null;
        HttpStatus status = null;

        try {
            // 핸드폰과 요금제에 맞는 공시지원금 조회를 위해 publicSupportService의 findPublicSupportResDto() 함수 호출
            publicSupportPrice = publicSupportService.findPublicSupportResDto(phoneId, planId);
            // 해당 공시지원금이 있을 경우 PublicSupportPrice 반환
            status = HttpStatus.OK;
            resultMap.put("PublicSupportPrice",publicSupportPrice);
        } catch (Exception e) {
            // Exception 발생 시 404 error 응답
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<Map<String,Object>>(resultMap, status);
    }
}