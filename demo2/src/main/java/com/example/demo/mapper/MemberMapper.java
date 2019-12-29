package com.example.demo.mapper;

import com.example.demo.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MemberMapper {

    public List<Member> getAllMembers();

    public Member getMemberById(int memberId);

    public Member getMemberByEmail(String email);

    public void insertMember(Member member);

    public void updateMember(@Param("memberID") int memberId, @Param("newMember") Member newMember);

    public void deleteMemberById(int memberId);

}
