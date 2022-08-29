package com.lguplus.LTF2_BE.api.controller;

import com.lguplus.LTF2_BE.api.dto.request.OrdersReqDto;
import com.lguplus.LTF2_BE.api.service.OrdersService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "Order", value = "상품 주문 API")
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@CrossOrigin("*")
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping
    @ApiOperation(value = "상품 주문", notes = "상품을 주문한다.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "성공"),
            @ApiResponse(code = 500, message = "상품을 등록하는데 실패하였습니다.")
    })
    public ResponseEntity<Map<String, Object>> createOrder(
            @RequestBody @ApiParam(value = "주문 정보", required = true) OrdersReqDto ordersReqDto) {

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        Long orderId = null;

        try {
            orderId = ordersService.createOrder(ordersReqDto);
            resultMap.put("orderId", orderId);
            status = HttpStatus.CREATED;
        } catch (Exception e) {
            resultMap.put("message", "상품을 등록하는데 실패하였습니다.");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }
}
