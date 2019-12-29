package com.example.demo.mapper;

import com.example.demo.entity.Borrowing;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BorrowingMapper {

    public List<Borrowing> getAllBorrowingOption(@Param("memberId") int memberId, @Param("bookId") int bookId);

    public Borrowing getBookBorrow(int borrowingId);

    public void updateBorrowingBook(@Param("memberId") int memberId, @Param("bookId") int bookId);

    public void patchReturnBooks(int bookId);

    public void patchExtensionBooks(int bookId);

    public void deleteBorrow(int bookId);
}
