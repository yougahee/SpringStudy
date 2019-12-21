package com.example.demo.service;

import com.example.demo.entity.Member;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private List<Member> members = new ArrayList<>();
    private int autoIncrement =1;

    //멤버 추가
    public boolean saveMember(Member member) {
        member.setId(autoIncrement++);
        members.add(member);
        return true;
    }

    //멤버 조회
    public List<Member> getallMembers() {
        return members;
    }

    //멤버한명 반환
    public Member getMemberById(int memberId) {
        for(Member member : members){
            if(member.getId() == memberId) {
                return member;
            }
        }
        return null;
    }

    //멤버 수정
    public boolean putMemberById(int memberId, Member puttedMember) {
        for(Member member : members)
            if(member.getId() == memberId)
            {
                member.setId(puttedMember.getId());
                member.setEmail(puttedMember.getEmail());
                member.setName(puttedMember.getName());
                member.setPassword(puttedMember.getPassword());
                member.setPhoneNumber(puttedMember.getPhoneNumber());
                return true;
            }
        return false;
    }

    //멤버 삭제
    public Member deleteMemberById(int memberId) {
        for(Member member : members)
            if(member.getId() == memberId)
            {
                members.remove(member);
                return member;
            }
        return null;
    }
}
