package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookMapper bookMapper;

    public BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }


    //도서추가
    public boolean addBook(Book book){
        bookMapper.insertBook(book);
        return true;
    }

    //모든 도서조회
    public List<Book> getAllBook(){
        return bookMapper.getAllBooks();
    }

    //해당도서정보조회
    public Book getBookById(int bookId) {
        return bookMapper.getBookById(bookId);
    }

    //도서수정
    public boolean putBook(int bookId, Book puttedBook){
        bookMapper.updateBook(bookId, puttedBook);
        return true;
    }

    //도서삭제
    public boolean deleteBook(int bookId){
        bookMapper.deleteBook(bookId);
        return true;
    }


}
