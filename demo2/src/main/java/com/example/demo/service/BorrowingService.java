package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Borrowing;
import com.example.demo.entity.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BorrowingService {

    private List<Borrowing> borrowings = new ArrayList<>();
    private List<Borrowing> addBorrowings = new ArrayList<>();
    Date today = new Date();
    Date expireday = new Date();
    Calendar cal = Calendar.getInstance();

    private int autoIncrement = 1;
    private final MemberService memberService;
    private final BookService bookService;

    public BorrowingService(MemberService memberService, BookService bookService) {
        this.memberService = memberService;
        this.bookService = bookService;
    }

   /* 1. GET /api/borrowings?memberId={memberId}&bookId={bookId}
    대출내역 조회 (memberId, bookId는 옵션! 둘 다 없으면 전체 대출내역 조회)
    ex) GET /api/borrowings?memberId=3 	=> memberId가 3인 회원의 대출내역 조회
    ex) GET /api/borrowings?bookId=3 	=> bookId가 3인 도서의 대출내역 조회
    ex) GET /api/borrowings?memberId=3&bookId=3 	=> memberId가 3이고, bookId가 3인 대출내역 조회
    ex) GET /api/borrowings 		=> 전체 대출내역 조회*/

    //대출내역 조회 (memberId, bookId는 옵션! 둘 다 없으면 전체 대출내역 조회)
    public List<Borrowing> getallBorrowingOption(int memberId, int bookId) {
        //memberId만 있을 경우 -> 전체적으로 borrowings, 즉 List가 반환값이면 List전체 담겨져 있는 것을 반환하는 듯하다
        //어떻게 해당하는 것들만 반환할 수 있을까..?
        if (memberId > 0 && bookId == 0) {
            addBorrowings.clear();
            for (Borrowing borrowing : borrowings) {
                if (borrowing.getMember().getId() == memberId) {
                    addBorrowings.add(borrowing);
                }
            }
            return addBorrowings;
        }
        //bookId만 있을 경우 --> 안됨
        else if (memberId == 0 && bookId > 0) {
            addBorrowings.clear();
            for (Borrowing borrowing : borrowings) {
                if (borrowing.getBook().getId() == bookId) {
                    addBorrowings.add(borrowing);
                }
            }
            return addBorrowings;
        }
        //둘다 있을 경우 --> 안됨
        else if (memberId > 0 && bookId > 0) {
            addBorrowings.clear();
            for (Borrowing borrowing : borrowings) {
                if (borrowing.getMember().getId() == memberId && borrowing.getBook().getId() == bookId) {
                    addBorrowings.add(borrowing);
                }
            }
            return addBorrowings;
        }
        //아니면 전체 대출내역 조회
        //여기 안나오는 듯
        else {
            return borrowings;
        }
    }

    //borrowingId를 가진 대출내역 조회
    public Borrowing getBookBorrow(int borrowingId) {
        for (Borrowing borrowing : borrowings) {
            if (borrowing.getId() == borrowingId) {
                return borrowing;
            }
        }
        return null;
    }

    /*
    2. POST /api/borrowings/members/{memberId}/books/{bookId}
    도서 대출 (기본 대출 기간은 7일로, book의 isOut을 true로 변경) */

    //도서대출
    public boolean postBorrowingBooks(int memberId, int bookId) {
        if (memberService.getMemberById(memberId) != null && bookService.getBook(bookId,1) != null) {
            Borrowing borrowing = new Borrowing();
            borrowing.setId(autoIncrement++);
            //isOut true로 바꿈
            //잘 모르겠음 이거는!
            //borrowing.setBook().setOut(true);
            //Member
            borrowing.setMember(memberService.getMemberById(memberId));
            //Book
            borrowing.setBook(bookService.getBook(bookId,1));
            //대출기간 7일##바꾸기!##
            borrowing.setStartTime(today);
            cal.add(Calendar.DAY_OF_MONTH, 7);
            expireday = cal.getTime();
            borrowing.setExpireTime(expireday);
            borrowing.setReturnTime(null);
            //returnday는 아직 null
            //Q 이것도 하는 게 맞는건가?
            borrowings.add(borrowing);

            return true;
        }
        return false;
    }


    //도서반납
    public boolean patchReturnBooks(int bookId) {
        for (Borrowing borrowing : borrowings) {
            if (borrowing.getBook().getId() == bookId) {
                //returnDate를 반납한 현재 시각으로 수정
                borrowing.setReturnTime(today);
                //book의 isOut을 false로 변경
                borrowing.getBook().setOut(false);
                return true;
            }
        }
        return false;
    }

    //도서연장
    public boolean patchExtensionBooks(int bookId) {
        for (Borrowing borrowing : borrowings) {
            if (borrowing.getBook().getId() == bookId) {
                //expiryDate를 7일 연장..
                cal.add(Calendar.DAY_OF_MONTH, 7);
                expireday = cal.getTime();
                borrowing.setExpireTime(expireday);
                return true;
            }
        }
        return false;
    }

    //대출내역삭제
    public boolean deleteBorrow(int borrowingId) {
        for (Borrowing borrowing : borrowings) {
            if (borrowing.getId() == borrowingId) {
                borrowings.remove(borrowingId);
                return true;
            }
        }
        return false;
    }
}
