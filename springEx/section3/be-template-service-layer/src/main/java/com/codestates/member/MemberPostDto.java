package com.codestates.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class MemberPostDto {
    @NotBlank
    @Email
    private String email;

    @NotBlank(message = "이름은 공백이 아니어야 합니다.")
    private String name;

    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
            message = "휴대폰 번호는 010으로 시작하는 11자리 숫자와 '-'로 구성되어야 합니다.")
    private String phone;

//    public Member MemberPostDtoToMember() {
//        return Member.builder()
//                .email(email)
//                .name(name)
//                .phone(phone)
//                .build();
//    }
}
