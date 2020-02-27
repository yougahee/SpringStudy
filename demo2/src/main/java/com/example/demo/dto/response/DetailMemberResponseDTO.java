package com.example.demo.dto.response;

import com.example.demo.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class DetailMemberResponseDTO {
    private int id;
    private String email;
    private String name;
    private String phoneNumber;

    public static DetailMemberResponseDTO of(Member member){
        return DetailMemberResponseDTO.builder()
                .id(member.getId())
                .email(member.getEmail())
                .name(member.getName())
                .phoneNumber(member.getPhoneNumber())
                .build();
    }
}
