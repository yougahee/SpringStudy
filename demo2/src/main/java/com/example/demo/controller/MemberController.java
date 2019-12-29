package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//경로를 일부러 복수형으로 맞춰줬음
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //멤버 추가
    @PostMapping
    public boolean saveMember(@RequestBody Member member){
        return memberService.saveMember(member);
    }

    //멤버 조회
    @GetMapping
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    //id에 맞는 멤버 조회 member가져오기
    @GetMapping("/{memberId}")
    public Member getMemberById(@PathVariable("memberId") int memberId) {
        return memberService.getMemberById(memberId);
    }

    //수정
    @PutMapping("/{memberId}")
    public boolean putMembers(@PathVariable("memberId") int memberId, @RequestBody Member puttedMember) {
        return memberService.putMemberById(memberId, puttedMember);
    }

    //삭제
    @DeleteMapping("/{memberId}")
    public boolean deleteMembers(@PathVariable("memberId") int memberId) {
        return memberService.deleteMemberById(memberId);
    }


}
