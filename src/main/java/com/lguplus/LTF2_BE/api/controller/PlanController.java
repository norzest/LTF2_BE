package com.lguplus.LTF2_BE.api.controller;

import com.lguplus.LTF2_BE.api.dto.response.PlanResDto;
import com.lguplus.LTF2_BE.api.service.PlanService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "Plan", value = "요금제 API")
@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PlanController {

    private final PlanService planService;

    @GetMapping
    @ApiOperation(value = "요금제 전체 조회", notes = "모든 요금제를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 404, message = "해당하는 요금제가 존재하지 않습니다."),
            @ApiResponse(code = 200, message = "요금제를 불러오는데 실패하였습니다.")
    })
    public ResponseEntity<Map<String, Object>> findAll() {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        List<PlanResDto> result = null;

        try {
            result = planService.findAll();

            if(result.size() == 0) {
                resultMap.put("message", "해당하는 요금제가 존재하지 않습니다.");
                status = HttpStatus.NOT_FOUND;
            } else {
                resultMap.put("PlanList", result);
                status = HttpStatus.OK;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("message", "요금제를 불러오는데 실패하였습니다.");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(resultMap, status);
        }

        return new ResponseEntity<>(resultMap, status);
    }

    @GetMapping("/telecom-tech/{telecom_tech}")
    @ApiOperation(value = "통신기술에 따른 요금제 조회", notes = "특정한 통신기술의 요금제 리스트를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 404, message = "해당하는 요금제가 존재하지 않습니다."),
            @ApiResponse(code = 200, message = "요금제를 불러오는데 실패하였습니다.")
    })
    public ResponseEntity<Map<String, Object>> findByTelecomTech(
            @PathVariable(value="telecom_tech") @ApiParam(value = "통신기술명", required = true, example = "5G") String telecomTech) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        List<PlanResDto> result = null;
        try {
            result = planService.findByTelecomTech(telecomTech);

            if(result.size() == 0) {
                resultMap.put("message", "해당하는 요금제가 존재하지 않습니다.");
                status = HttpStatus.NOT_FOUND;
            } else {
                resultMap.put("PlanList", result);
                status = HttpStatus.OK;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("message", "요금제를 불러오는데 실패하였습니다.");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(resultMap, status);
        }

        return new ResponseEntity<>(resultMap, status);
    }

    @GetMapping("/{plan_id}")
    @ApiOperation(value = "특정 요금제 조회", notes = "특정한 요금제를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 404, message = "해당하는 요금제가 존재하지 않습니다."),
            @ApiResponse(code = 200, message = "요금제를 불러오는데 실패하였습니다.")
    })
    public ResponseEntity<Map<String, Object>> findOne(
            @PathVariable(value="plan_id") @ApiParam(value = "요금제 Id", required = true, example = "1") Long planId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        PlanResDto result = null;

        try {
            result = planService.findOne(planId);

            if(result == null) {
                resultMap.put("message", "해당하는 요금제가 존재하지 않습니다.");
                status = HttpStatus.NOT_FOUND;
            } else {
                resultMap.put("Plan", result);
                status = HttpStatus.OK;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("message", "요금제를 불러오는데 실패하였습니다.");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(resultMap, status);
        }

        return new ResponseEntity<>(resultMap, status);
    }
}
