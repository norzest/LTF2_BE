package com.lguplus.LTF2_BE.api.controller;

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

        phoneList = phoneService.findPhones();
        status = HttpStatus.OK;
        resultMap.put("phoneList", phoneList);

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @GetMapping("/{phoneId}")
    public ResponseEntity<Map<String, Object>> findPhoneDetail(
            @PathVariable Long phoneId) {

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;


    }
}
