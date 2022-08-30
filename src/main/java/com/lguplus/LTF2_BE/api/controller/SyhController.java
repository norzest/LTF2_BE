package com.lguplus.LTF2_BE.api.controller;

import com.lguplus.LTF2_BE.api.util.SymSpell;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/syh")
public class SyhController {

    @GetMapping
    public ResponseEntity<Map<String, Object>> syh() {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.OK;
        

        return new ResponseEntity<>(resultMap, status);
    }
}
