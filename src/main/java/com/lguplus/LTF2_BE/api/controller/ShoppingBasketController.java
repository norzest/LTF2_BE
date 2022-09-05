package com.lguplus.LTF2_BE.api.controller;

import com.lguplus.LTF2_BE.api.dto.response.ShoppingBasketResDto;
import com.lguplus.LTF2_BE.api.service.ShoppingBasketService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

// writer : 권혁준
@Api(tags = "ShoppingBasket", value = "장바구니 API")
@RestController
@RequestMapping("/shopping-basket")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ShoppingBasketController {

    private final ShoppingBasketService shoppingBasketService;

    @GetMapping("/phone/{phone_id}/plan/{plan_id}/color/{color_id}")
    @ApiOperation(value = "장바구니 데이터 조회", notes = "장바구니 데이터를 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 404, message = "id를 다시 확인해주세요."),
            @ApiResponse(code = 500, message = "장바구니 데이터를 불러오는데 실패하였습니다."),
    })
    public ResponseEntity<Map<String, Object>> findShoppingBasket(
            @PathVariable(value = "phone_id") @ApiParam(value = "상품 id", required = true, example = "1") Long phoneId,
            @PathVariable(value = "plan_id") @ApiParam(value = "요금제 id", required = true, example = "1") Long planId,
            @PathVariable(value = "color_id") @ApiParam(value = "색깔 id", required = true, example = "1") Long colorId) {

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        ShoppingBasketResDto shoppingBasket = null;

        try {
            // 장바구니 데이터 조회를 위해 shoppingBasketService의 findShoppingBasket() 함수 호출
            shoppingBasket = shoppingBasketService.findShoppingBasket(phoneId, planId, colorId);

            // 장바구니 데이터가 있을 경우 client에 shoppingBasket 반환
            resultMap.put("shoppingBasket", shoppingBasket);
            status = HttpStatus.OK;
        } catch (NoSuchElementException e) {
            // NoSuchElementException 발생 시 404 error 응답
            resultMap.put("message", "id를 다시 확인해주세요.");
            status = HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            // 그 외 Exception 발생 시 500 error 응답
            resultMap.put("message", "장바구니 데이터를 불러오는데 실패하였습니다.");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }
}