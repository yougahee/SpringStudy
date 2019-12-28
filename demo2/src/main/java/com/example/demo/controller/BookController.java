package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //도서추가
    @PostMapping
    public boolean addBook(@RequestBody Book book){ return bookService.addBook(book); }

    //모든도서조회
    @GetMapping
    public List<Book> getBook() {
        return bookService.getAllBook();
    }

    //도서조회
    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable("bookId") int bookId) {
        return bookService.getBookById(bookId);
    }

    //도서수정
    @PutMapping("/{bookId}")
    public boolean putBook(@PathVariable("bookId") int bookId, @RequestBody Book puttedBook){
        return bookService.putBook(bookId, puttedBook);
}
    //도서삭제
    @DeleteMapping("/{bookId}")
    public boolean deleteBook(@PathVariable("bookId") int bookId) {
        return bookService.deleteBook(bookId);
    }

}


