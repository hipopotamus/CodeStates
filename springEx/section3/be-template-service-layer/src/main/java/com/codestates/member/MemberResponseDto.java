package com.codestates.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class MemberResponseDto {
    private long memberId;
    private String email;
    private String name;
    private String phone;

//    public MemberResponseDto(Member member) {
//        this.memberId = member.getId();
//        this.email = member.getEmail();
//        this.name = member.getName();
//        this.phone = member.getPhone();
//    }
}
