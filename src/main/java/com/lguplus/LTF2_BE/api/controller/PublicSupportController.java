package com.lguplus.LTF2_BE.api.controller;

import com.lguplus.LTF2_BE.api.dto.response.PublicSupportPhoneResDto;
import com.lguplus.LTF2_BE.api.dto.response.PublicSupportPlanResDto;
import com.lguplus.LTF2_BE.api.service.PublicSupportService;
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
@RequestMapping("/public-support")
@RequiredArgsConstructor
public class PublicSupportController {

    private final PublicSupportService publicSupportService;

    @GetMapping("/phone/{phone_id}")
    public ResponseEntity<Map<String,Object>> findPublicSupportPlan(@PathVariable(value = "phone_id") Long phoneId){
        Map<String, Object> resultMap = new HashMap<>();
        List<PublicSupportPlanResDto> publicSupportPhoneResList = null;
        HttpStatus status = null;

        try {
            publicSupportPhoneResList = publicSupportService.findPublicSupportPlanResDto(phoneId);
            status = HttpStatus.OK;
            resultMap.put("PlanList",publicSupportPhoneResList);
        } catch (Exception e) {
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<Map<String,Object>>(resultMap, status);
    }

    @GetMapping("/plan/{plan_id}")
    public ResponseEntity<Map<String,Object>> findPublicSupportPhone(@PathVariable(value = "plan_id") Long planId){
        Map<String, Object> resultMap = new HashMap<>();
        List<PublicSupportPhoneResDto> publicSupportPhoneResList = null;
        HttpStatus status = null;

        try {
            publicSupportPhoneResList = publicSupportService.findPublicSupportPhoneResDto(planId);
            status = HttpStatus.OK;
            resultMap.put("PhoneList",publicSupportPhoneResList);
        } catch (Exception e) {
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<Map<String,Object>>(resultMap, status);
    }

    @GetMapping("/phone/{phone_id}/plan/{plan_id}")
    public ResponseEntity<Map<String,Object>> findPublicSupportPrice(@PathVariable(value = "phone_id") Long phoneId, @PathVariable(value = "plan_id") Long planId){
        Map<String, Object> resultMap = new HashMap<>();
        Integer publicSupportPrice = null;
        HttpStatus status = null;

        try {
            publicSupportPrice = publicSupportService.findPublicSupportResDto(phoneId, planId);
            status = HttpStatus.OK;
            resultMap.put("PublicSupportPrice",publicSupportPrice);
        } catch (Exception e) {
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<Map<String,Object>>(resultMap, status);
    }
}
