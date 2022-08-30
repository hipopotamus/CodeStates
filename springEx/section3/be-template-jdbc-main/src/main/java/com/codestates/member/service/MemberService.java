package com.codestates.member.service;

import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.member.dto.MemberResponseDto;
import com.codestates.member.entity.Member;
import com.codestates.member.mapper.MemberMapper;
import com.codestates.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * V2
 *  - 메서드 구현
 *  - DI 적용
 */
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public Member createMember(Member member) {
        // TODO should business logic
        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {
        // TODO should business logic

        Member findMember = memberRepository.findById(member.getMemberId())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        findMember.setName(member.getName());
        findMember.setPhone(member.getPhone());
        memberRepository.save(findMember);
        return findMember;
    }

    public Member findMember(long memberId) {
        // TODO should business logic

        return memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }

    public List<Member> findMembers() {
        // TODO should business logic

        return (List<Member>) memberRepository.findAll();
    }

    public void deleteMember(long memberId) {
        // TODO should business logic

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        memberRepository.delete(member);
    }

    public Page<MemberResponseDto> memberPage(Pageable pageable) {
        Page<Member> members = memberRepository.findAllByOrderByMemberIdDesc(pageable);
        List<MemberResponseDto> memberDtoList = memberMapper.membersToMemberResponseDtos(members.getContent());
        PageImpl<MemberResponseDto> pagination = new PageImpl<>(memberDtoList, pageable, pageable.getPageSize());
        return pagination;
    }
}
