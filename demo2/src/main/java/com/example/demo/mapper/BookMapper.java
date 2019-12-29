package com.example.demo.mapper;

import com.example.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BookMapper {

    public void insertBook(Book book);

    public List<Book> getAllBooks();

    public Book getBookById(int bookId);

    public void updateBook(@Param("bookId") int bookId, @Param("newBook") Book book);

    public void deleteBook(int bookId);
}
