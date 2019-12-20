package com.example.demo.entity;

public class Book {

    private int id;
    private String title;
    private String author;
    //기본값을 false가 될텐데 대출을 하면 true로 바꿔줘야함
    private boolean isOut;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setOut(boolean out) {
        isOut = out;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isOut() {
        return isOut;
    }
}
