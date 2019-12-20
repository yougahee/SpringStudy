package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.service.StringService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/string")
public class StringController {

    private final StringService stringService;

    public StringController(StringService stringService) {
        this.stringService = stringService;
    }

    //문자열합치기
    @GetMapping("/append")
    public String append(String str1, String str2) {
        return this.stringService.append(str1, str2);
    }

    //포함하고 있는지 여부
    @GetMapping("/contains")
    public Boolean contains(String str1, String str2) {
        return this.stringService.contains(str1, str2);
    }

    //문자열길이
    @GetMapping("/len")
    public int len(String str1) {
        return this.stringService.len(str1);
    }

    //같은 문자열인지
    @GetMapping("/equals")
    public Boolean equals(String str1, String str2) {
        return this.stringService.equals(str1, str2);
    }
}
