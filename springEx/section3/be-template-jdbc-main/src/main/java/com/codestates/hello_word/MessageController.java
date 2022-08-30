package com.codestates.hello_word;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/messages")
public class MessageController {

    private final MessageService messageService;
    private final MessageMapper mapper;

    @PostMapping
    public ResponseEntity postMessage(@Valid @RequestBody MessagePostDto messagePostDto) {
        Message message = messageService.createMessage(mapper.messageDtoTOMessage(messagePostDto));
        return new ResponseEntity(mapper.messageToMessageDto(message), HttpStatus.OK);
    }

}
