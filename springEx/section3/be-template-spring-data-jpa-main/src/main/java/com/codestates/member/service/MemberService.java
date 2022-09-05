package com.codestates.member.service;

import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.member.MemberRepository;
import com.codestates.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member createMember(Member member) {
        // TODO should business logic

        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {
        // TODO should business logic

        Member findMember = memberRepository.findById(member.getId())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        findMember.setName(member.getName());
        findMember.setPhone(member.getPhone());
        findMember.setMemberStatus(member.getMemberStatus());
        findMember.setModifiedAt(LocalDateTime.now());

        return findMember;
    }

    public Member findMember(long memberId) {
        // TODO should business logic
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }

    public Page<Member> findMembers(int page, int size) {
        // TODO should business logic

        return memberRepository.paginationByMemberId(PageRequest.of(page, size));
    }

    public void deleteMember(long memberId) {
        // TODO should business logic

        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        memberRepository.delete(findMember);
    }
}
