package com.example.demo.controller;

import com.example.demo.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//class 앞?에도 requestmapping을 해주면
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    //생성자 Alt+insert
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    //RequestParam을 명시안해줘도 실행은 될 것이지만
    //협업을 위해서는 requestParam을 써줘서 명시해주는 게 좋음
    @GetMapping("/sum")
    public int sum(@RequestParam int num1, @RequestParam int num2) {
        //서비스로 넘겨줌
        return calculatorService.sum(num1, num2);
    }

    //빼기
    @GetMapping("/sub")
    public int sub(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.sub(num1, num2);
    }

    //곱하기
    @GetMapping("/mul")
    public int mul(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.mul(num1, num2);
    }

    //나눗셈
    @GetMapping("/div")
    public int div(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.div(num1, num2);
    }

    //나머지
    @GetMapping("/mod")
    public int mod(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.mod(num1, num2);
    }

    //작은값
    @GetMapping("/min")
    public int min(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.min(num1, num2);
    }

    //큰 값
    @GetMapping("/max")
    public int max(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.max(num1, num2);
    }

    //제곱
    @GetMapping("/pow")
    public int pow(@RequestParam int num1, @RequestParam int num2) {
        return calculatorService.pow(num1, num2);
    }

}
