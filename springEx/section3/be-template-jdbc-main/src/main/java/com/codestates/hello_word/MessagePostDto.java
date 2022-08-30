package com.codestates.hello_word;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class MessagePostDto {
    @NotBlank
    private String message;
}
