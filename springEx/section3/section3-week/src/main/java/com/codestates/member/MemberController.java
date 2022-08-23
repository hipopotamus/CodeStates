package com.codestates.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/v1/members")
public class MemberController {

    @PostMapping
    public ResponseEntity<MemberDto> postMember(@Valid @RequestBody MemberDto memberDto) {
        return new ResponseEntity<>(memberDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MemberDto> putMember(@Valid @RequestBody MemberDto memberDto) {
        return new ResponseEntity<>(memberDto, HttpStatus.OK);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<Void> getMember(@PathVariable long memberId) {
        log.info("# memberId: {}", memberId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Void> getMembers() {
        log.info("# get Members");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable long memberId) {
        log.info("# delete member: {}", memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
