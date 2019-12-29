package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Book {

    private int id;
    private String title;
    private String author;
    //기본값을 false가 될텐데 대출을 하면 true로 바꿔줘야함
    private boolean isOut;
}
