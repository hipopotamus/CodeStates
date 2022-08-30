package com.codestates.hello_word;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message messageDtoTOMessage(MessagePostDto messagePostDto);
    MessageResponseDto messageToMessageDto(Message message);
}
