package com.lguplus.LTF2_BE.api.controller;

import com.lguplus.LTF2_BE.api.dto.response.PhoneDetailResDto;
import com.lguplus.LTF2_BE.api.dto.response.PhoneResDto;
import com.lguplus.LTF2_BE.api.service.PhoneService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

// writer : 최강현
@Api(tags = "Phone", value = "상품 API")
@RestController
@RequestMapping("/phone")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping
    @ApiOperation(value = "상품 전체 조회", notes = "상품을 전체 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 404, message = "해당하는 상품이 존재하지 않습니다."),
            @ApiResponse(code = 500, message = "상품을 불러오는데 실패하였습니다."),
    })
    public ResponseEntity<Map<String, Object>> findPhones() {

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        List<PhoneResDto> phoneList = null;

        try {
            // 상품 전체 조회를 위해 phoneService의 findPhones() 함수 호출
            phoneList = phoneService.findPhones();

            if (phoneList.size() == 0) {
                // 상품 리스트가 없을 경우 NoSuchElementException 발생
                throw new NoSuchElementException();
            } else {
                // 상품 리스트가 있을 경우 client에 phoneList 반환
                resultMap.put("phoneList", phoneList);
                status = HttpStatus.OK;
            }
        } catch (NoSuchElementException e) {
            // NoSuchElementException 발생 시 404 error 응답
            resultMap.put("message", "해당하는 상품이 존재하지 않습니다.");
            status = HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            // 그 외 Exception 발생 시 500 error 응답
            resultMap.put("message", "상품을 불러오는데 실패하였습니다.");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    @GetMapping("/telecom-tech/{telecom_tech}")
    @ApiOperation(value = "통신기술에 따른 상품 리스트 조회", notes = "통신기술에 따른 상품을 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 404, message = "해당하는 상품이 존재하지 않습니다."),
            @ApiResponse(code = 500, message = "상품을 불러오는데 실패하였습니다."),
    })
    public ResponseEntity<Map<String, Object>> findPhonesByTelecomTech(
            @PathVariable(value = "telecom_tech") @ApiParam(value = "통신기술명", required = true, example = "5G") String telecomTech) {

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        List<PhoneResDto> phoneList = null;

        try {
            // 통신기술에 따른 상품 리스트 조회를 위해 phoneService의 findPhonesByTelecomTech() 함수 호출
            phoneList = phoneService.findPhonesByTelecomTech(telecomTech);

            // 상품 리스트가 있을 경우 client에 phoneList 반환
            resultMap.put("phoneList", phoneList);
            status = HttpStatus.OK;
        } catch (NoSuchElementException e) {
            // NoSuchElementException 발생 시 404 error 응답
            resultMap.put("message", "해당하는 상품이 존재하지 않습니다.");
            status = HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            // 그 외 Exception 발생 시 500 error 응답
            resultMap.put("message", "상품을 불러오는데 실패하였습니다.");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    @GetMapping("/{phone_id}")
    @ApiOperation(value = "상품 상세 조회", notes = "상품을 상세 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 404, message = "해당하는 상품이 존재하지 않습니다."),
            @ApiResponse(code = 500, message = "상품을 불러오는데 실패하였습니다."),
    })
    public ResponseEntity<Map<String, Object>> findPhoneDetail(
            @PathVariable(value = "phone_id") @ApiParam(value = "상품 id", required = true, example = "1") Long phoneId) {

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        PhoneDetailResDto phoneDetail = null;

        try {
            // 상품 상세 조회를 위해 phoneService의 findPhoneDetail() 함수 호출
            phoneDetail = phoneService.findPhoneDetail(phoneId);

            // 상품이 있을 경우 client에 phoneDetail 반환
            resultMap.put("phoneDetail", phoneDetail);
            status = HttpStatus.OK;
        } catch (NoSuchElementException e) {
            // NoSuchElementException 발생 시 404 error 응답
            resultMap.put("message", "해당하는 상품이 존재하지 않습니다.");
            status = HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            // 그 외 Exception 발생 시 500 error 응답
            resultMap.put("message", "상품을 불러오는데 실패하였습니다.");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }
}
