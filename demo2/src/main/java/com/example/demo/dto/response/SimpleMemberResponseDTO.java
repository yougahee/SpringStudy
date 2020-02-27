package com.example.demo.dto.response;

import com.example.demo.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class SimpleMemberResponseDTO {
    private int id;
    private String name;
    private String phoneNumber;

    public static SimpleMemberResponseDTO of(Member member) {
        return SimpleMemberResponseDTO.builder()
                .id(member.getId())
                .name(member.getName())
                .phoneNumber(member.getPhoneNumber())
                .build();
    }
}
