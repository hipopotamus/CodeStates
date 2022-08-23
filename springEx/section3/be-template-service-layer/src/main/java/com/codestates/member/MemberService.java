package com.codestates.member;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    public Member createMember(Member member) {
        return member;
    }

    public Member updateMember(Member member) {
        return member;
    }

    public Member findMember(long memberId) {
        return new Member(memberId, "mock@mock.com", "mock", "010-0000-0000");
    }

    public List<Member> findMembers() {
        ArrayList<Member> memberList = new ArrayList<>();
        Member member1 = new Member(1, "mock1@mock.com", "mock1", "010-0000-0000");
        Member member2 = new Member(2, "mock2@mock.com", "mock2", "010-0000-0000");
        memberList.add(member1);
        memberList.add(member2);
        return memberList;
    }

    public void deleteMember(long memberId) {
    }

}
