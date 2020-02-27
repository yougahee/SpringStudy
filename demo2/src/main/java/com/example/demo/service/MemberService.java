package com.example.demo.service;

import com.example.demo.dto.response.DetailMemberResponseDTO;
import com.example.demo.dto.response.SimpleMemberResponseDTO;
import com.example.demo.entity.Member;
import com.example.demo.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    //멤버 추가
    public boolean saveMember(Member member) {
        memberMapper.insertMember(member);
        return true;
    }

    //멤버 조회
    public List<SimpleMemberResponseDTO> getAllMembers() {
        List<SimpleMemberResponseDTO> addMemberList = new ArrayList<>();
        for(Member member : memberMapper.getAllMembers()) {
           addMemberList.add(SimpleMemberResponseDTO.of(member));
        }
        return addMemberList;
    }

    //멤버한명 반환
    public DetailMemberResponseDTO getMemberById(int memberId) {
        return DetailMemberResponseDTO.of(memberMapper.getMemberById(memberId));
    }

    //멤버 수정
    public boolean putMemberById(int memberId, Member puttedMember) {
        memberMapper.updateMember(memberId, puttedMember);
        return true;
    }

    //멤버 삭제
    public boolean deleteMemberById(int memberId) {
        memberMapper.deleteMemberById(memberId);

        return true;
    }
}
