package com.codestates.member;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-23T15:21:55+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 11.0.16.1 (BellSoft)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostDtoToMember(MemberPostDto memberPostDto) {
        if ( memberPostDto == null ) {
            return null;
        }

        Member.MemberBuilder member = Member.builder();

        return member.build();
    }

    @Override
    public Member memberPatchDtoToMember(MemberPatchDto memberPostDto) {
        if ( memberPostDto == null ) {
            return null;
        }

        Member.MemberBuilder member = Member.builder();

        member.name( memberPostDto.getName() );
        member.phone( memberPostDto.getPhone() );

        return member.build();
    }

    @Override
    public MemberResponseDto memberToMemberResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        String email = null;
        String name = null;
        String phone = null;

        email = member.getEmail();
        name = member.getName();
        phone = member.getPhone();

        long memberId = 0L;

        MemberResponseDto memberResponseDto = new MemberResponseDto( memberId, email, name, phone );

        return memberResponseDto;
    }
}
