package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class StringService {

    public String append(String str1, String str2){
        return str1+str2;
    }

    public Boolean contains(String str1, String str2){
        if(str1.contains(str2))
            return true;
        else
            return false;
    }

    public int len(String str1){
        return str1.length();
    }

    public Boolean equals(String str1, String str2){
        if(str1.equals(str2))
            return true;
        else
            return false;
        
    }


}
