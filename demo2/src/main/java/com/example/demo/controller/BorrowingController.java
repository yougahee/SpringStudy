package com.example.demo.controller;

import com.example.demo.entity.Borrowing;
import com.example.demo.service.BorrowingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    //대출내역 조회
    @GetMapping
    public List<Borrowing> getAllBorrowingOption(@RequestParam(value = "memberId", required = false, defaultValue = "0") int memberId,
                                                 @RequestParam(value = "bookId", required = false, defaultValue = "0") int bookId){
      return borrowingService.getAllBorrowingOption(memberId, bookId);
    }

    //borrowingId를 가진 대출내역 조회
    @GetMapping("/{borrowingId}")
    public Borrowing getBookBorrow(@PathVariable("borrowingId") int borrowingId){
        return borrowingService.getBookBorrow(borrowingId);
    }

    //도서대출
    @PostMapping("/members/{memberId}/books/{bookId}")
    public boolean postBorrowingBooks(@PathVariable("memberId") int memberId, @PathVariable("bookId") int bookId){
        return borrowingService.postBorrowingBooks(memberId, bookId);
    }

    //도서반납
    @PatchMapping("/return/books/{bookId}")
    public boolean patchReturnBooks(@PathVariable("bookId") int bookId){
        return borrowingService.patchReturnBooks(bookId);
    }

    //도서대출기간연장
    @PatchMapping("/return/extension/{bookId}")
    public boolean patchExtensionBooks(@PathVariable("bookId") int bookId){
        return borrowingService.patchExtensionBooks(bookId);
    }

    //도서대출내역삭제
    @DeleteMapping("/{borrowingId}")
    public boolean deleteBorrow(@PathVariable("borrowingId") int borrowingId){
        return borrowingService.deleteBorrow(borrowingId);
    }


}
