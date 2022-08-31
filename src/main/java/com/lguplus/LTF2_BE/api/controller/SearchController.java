package com.lguplus.LTF2_BE.api.controller;

import com.lguplus.LTF2_BE.api.dto.response.PhoneResDto;
import com.lguplus.LTF2_BE.api.service.FixKeyWordService;
import com.lguplus.LTF2_BE.api.service.SearchService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "Search", value = "검색 API")
@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SearchController {

    private final SearchService searchService;
    private final FixKeyWordService fixKeyWordService;

    @GetMapping("/{key_word}")
    @ApiOperation(value = "키워드 검색", notes = "키워드를 통해 기기명이나 제조사로 검색한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 400, message = "검색에 실패하였습니다.")
    })
    public ResponseEntity<Map<String, Object>> search(
            @PathVariable(value="key_word") @ApiParam(value = "키워드", required = true, example = "갤럭시") String keyWord) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        List<PhoneResDto> result = null;

        try {
            result = searchService.searchPhones(keyWord);

            if (result.size() == 0) {
                String fixed = fixKeyWordService.fixKeyWord(keyWord);
                result = searchService.searchPhones(fixed);

                if(result.size() == 0) {
                    resultMap.put("message", "검색 결과가 없습니다.");
                } else {
                    resultMap.put("keyWord", fixed);
                    resultMap.put("SearchList", result);
                }

            } else {
                resultMap.put("keyWord", "");
                resultMap.put("SearchList", result);
            }

            status = HttpStatus.OK;
        } catch (NullPointerException e) {
            resultMap.put("message", "두 글자 이상의 검색어를 입력하세요.");
            status = HttpStatus.BAD_REQUEST;
        } catch (Exception e) {
            resultMap.put("message", "검색에 실패하였습니다.");
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(resultMap, status);
    }
}
