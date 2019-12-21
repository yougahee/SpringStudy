package com.example.demo.service;

import com.example.demo.entity.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();
    private int autoIncrement =1;

    //도서추가
    public boolean addBook(Book book){
        book.setId(autoIncrement++);
        books.add(book);
        //Q.setOut은 자동으로 false로 만들고 싶은데... 이렇게 해줘야 하는건가요??
        //아니면 작성하지 않으면 기본적으로 false로 들어가는 건가?
        //book.setOut(false);
        return true;
    }

    //모든 도서조회
    public List<Book> getallBook(){
        return books;
    }

    //해당도서정보조회
    public Book getBook(int bookId, int flag) {

        for(Book book : books) {
            if(bookId == book.getId() && flag ==1) {
                book.setOut(true);
                return book;
            }
            else if(bookId ==book.getId())
                return book;
        }
        return null;
    }

    //도서수정
    public boolean putBook(int bookId, Book puttedBook){
        for(Book book : books) {
            if(bookId == book.getId()) {
                book.setTitle(puttedBook.getTitle());
                book.setAuthor(puttedBook.getAuthor());
                return true;
            }
        }
        return false;
    }

    //도서삭제
    public boolean deleteBook(int bookId){
        for(Book book : books) {
            if(bookId == book.getId()) {
                books.remove(bookId);
                return true;
            }
        }
        return false;
    }


}
