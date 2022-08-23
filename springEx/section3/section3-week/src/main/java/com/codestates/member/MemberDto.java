package com.codestates.member;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class MemberDto {

    @NotNull
    private long memberId;

    @Email
    private String email;

//    @NotBlank(message = "이름은 공백이 아니여야 합니다.")
    @Pattern(regexp = "([a-zA-Z]+\\s?)*\\S$")
//    @Pattern(regexp = "^[a-zA-Z]+(?: [a-zA-Z]+)*$")
    @Pattern(regexp = "^([a-zA-Z])(\\s?[a-zA-Z])*$")
    private String name;

    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
    message = "휴대폰 번호는 010으로 시작하는 11자리 숫자와 '-'로 구성되어야 합니다.")
    private String phone;

    public MemberDto(String email, String name, String phone) {
        this.email = email;
        this.name = name;
        this.phone = phone;
    }
}
