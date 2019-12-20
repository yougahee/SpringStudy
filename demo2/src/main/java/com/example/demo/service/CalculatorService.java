package com.example.demo.service;

import org.springframework.stereotype.Service;

//어노테이션 --> 서비스 역할을 한다고 알려주는 것
@Service
public class CalculatorService {

    //덧셈
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    //곱셈
    public int mul(int num1, int num2) {
        return num1 * num2;
    }

    //마이너스
    public int sub(int num1, int num2) {
        return num1 - num2;
    }

    //나눗셈
    public int div(int num1, int num2) {
        return num1 / num2;
    }

    //나머지
    public int mod(int num1, int num2) {
        return num1 % num2;
    }

    //작은값
    public int min(int num1, int num2) {
        if(num1 > num2)
            return num2;
        else
            return num1;
    }

    //큰값
    public int max(int num1, int num2) {
        if(num1 < num2)
            return num2;
        else
            return num1;
    }

    //제곱
    public int pow(int num1, int num2) {
        int result =1;
        for(int i=0; i<num2; i++)
            result *= num1;
        return result;
    }

}
