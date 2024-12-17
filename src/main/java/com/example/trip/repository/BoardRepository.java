package com.example.trip.repository;

import com.example.trip.dto.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    // board테이블에서 id를 기준으로 내림차순한 게시글 목록 가져오기
    Page<Board> findAllByOrderByIdDesc(Pageable pageable);
}
