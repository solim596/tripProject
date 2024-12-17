package com.example.trip.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")  // 긴 문장 허용
    private String content;
    private LocalDate createdAt;    // 등록날짜
    private LocalDate modifyAt;     // 수정날짜
    private int count;              // 조회수
    private String username;        // 사용자 아이디

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDate.now();
        this.modifyAt = LocalDate.now();
        this.count = 0;
    }

    @PreUpdate
    protected void onUpdate() {
        this.modifyAt = LocalDate.now();
    }
}
