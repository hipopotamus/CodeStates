package com.codestates.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

// TODO 변경: Builder 패턴 적용
@Builder
@Getter
public class MemberResponseDto {
    private long id;
    private String email;
    private String name;
    private String phone;
}
