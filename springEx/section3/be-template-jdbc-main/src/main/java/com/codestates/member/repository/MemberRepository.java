package com.codestates.member.repository;

import com.codestates.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {
    // TODO 예제 코드에 나와있는 쿼리 메서드를 정의해보세요.
    Optional<Member> findByEmail(String email);

    Page<Member> findAllByOrderByMemberIdDesc(Pageable pageable);
}
