package com.example.trip.repository;

import com.example.trip.dto.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 아이디가 존재하는지 검사하는 메서드
    Boolean existsByUsername(String username);
    // Member테이블에서 아이디 찾는 메서드
    Optional<Member> findByUsername(String username);
    // Member테이블에서 이메일 찾는 메서드
    Optional<Member> findByEmail(String email);
    // 비밀번호 재설정할때 아이디와 비밀번호를 찾아서 일치하는 데이터가 있어야 함.
    Optional<Member> findByUsernameAndEmail(String username, String email);
}
