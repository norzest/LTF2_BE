package com.lguplus.LTF2_BE.api.controller;

import com.lguplus.LTF2_BE.api.dto.response.PhoneResDto;
import com.lguplus.LTF2_BE.api.service.SearchService;
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
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/{key_word}")
    public ResponseEntity<Map<String, Object>> search(@PathVariable(value="key_word") String keyWord) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;

        List<PhoneResDto> result = null;

        result = searchService.searchPhones(keyWord);

        try {
            if (result.size() == 0) {
                resultMap.put("message", "검색 결과가 없습니다.");
            } else {
                resultMap.put("SearchList", result);
            }
            status = HttpStatus.OK;
        } catch (NullPointerException e) {
            resultMap.put("message", "두 글자 이상의 검색어를 입력하세요.");
            status = HttpStatus.NOT_FOUND;
        } catch (Exception e) {
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(resultMap, status);
    }
}
