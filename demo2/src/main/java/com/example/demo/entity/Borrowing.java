package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Borrowing {

    private int id;
    private Book book;
    private Member member;
    private Date startTime;
    private Date expireTime;
    private Date returnTime;

}
