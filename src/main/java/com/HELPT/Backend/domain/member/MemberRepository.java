package com.HELPT.Backend.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long>, MemberRepositoryCustom {

    Optional<Member> findByKakaoId(Long kakaoId);
}
