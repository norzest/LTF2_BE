package com.lguplus.LTF2_BE.api.controller;

import com.lguplus.LTF2_BE.api.dto.response.PhoneDetailResDto;
import com.lguplus.LTF2_BE.api.dto.response.PhoneResDto;
import com.lguplus.LTF2_BE.api.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/phone")
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> findPhones() {

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        List<PhoneResDto> phoneList = null;

        try {
            phoneList = phoneService.findPhones();

            if (phoneList.size() == 0) {
                resultMap.put("message", "해당하는 상품이 존재하지 않습니다.");
                status = HttpStatus.NOT_FOUND;
            } else {
                resultMap.put("phoneList", phoneList);
                status = HttpStatus.OK;
            }
        } catch (Exception e) {
            resultMap.put("message", "상품을 불러오는데 실패하였습니다.");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    @GetMapping("/telecom-tech/{telecom_tech}")
    public ResponseEntity<Map<String, Object>> findPhonesByTelecomTech(
            @PathVariable(value = "telecom_tech") String telecomTech) {

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        List<PhoneResDto> phoneList = null;

        try {
            phoneList = phoneService.findPhonesByTelecomTech(telecomTech);

            if (phoneList.size() == 0) {
                resultMap.put("message", "해당하는 상품이 존재하지 않습니다.");
                status = HttpStatus.NOT_FOUND;
            } else {
                resultMap.put("phoneList", phoneList);
                status = HttpStatus.OK;
            }
        } catch (Exception e) {
            resultMap.put("message", "상품을 불러오는데 실패하였습니다.");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    @GetMapping("/{phone_id}")
    public ResponseEntity<Map<String, Object>> findPhoneDetail(
            @PathVariable(value = "phone_id") Long phoneId) {

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        PhoneDetailResDto phoneDetail = null;

        try {
            phoneDetail = phoneService.findPhoneDetail(phoneId);

            resultMap.put("phoneDetail", phoneDetail);
            status = HttpStatus.OK;
        } catch (NoSuchElementException e) {
            resultMap.put("message", "해당하는 상품이 존재하지 않습니다.");
            status = HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            resultMap.put("message", "상품을 불러오는데 실패하였습니다.");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }
}
