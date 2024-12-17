package com.example.trip.service;

import com.example.trip.dto.Board;
import com.example.trip.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

// @Transactional : 선언적 데이터베이스 트랜젝션 관리하는 객체
// 해당 메서드를 실행한 후 commit하거나 rollback하는 행위를 트랜젝션이라고 함
@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    // 게시글 목록 가져오기
    public List<Board> getAll() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
    // 게시글 쓰기
    public void writeBoard(String title, String content) {
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        boardRepository.save(board);
    }
    // 상세보기, 조회수 증가
    public Board getBoard(Long id) {
        // 매개변수로 전달받은 id값으로 게시글을 찾아서 그 게시글의 조회수를 증가시키고, 게시글을 못찾으면 예외처리함.
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        board.setCount(board.getCount() + 1);
        return board;
    }

    // 게시글 수정하기
    public void modifyBoard(Board board, String title, String content) {
        board.setTitle(title);
        board.setContent(content);
        board.setModifyAt(LocalDate.now());
        boardRepository.save(board);
    }
    // 게시글 삭제하기
    public void deleteBoard(Board board) {
        boardRepository.delete(board);
    }
    // 최근 게시글 4개 가져오기
    public List<Board> getPosts(int count) {
        return boardRepository.findAllByOrderByIdDesc(PageRequest.of(0, count)).getContent();
    }
}
