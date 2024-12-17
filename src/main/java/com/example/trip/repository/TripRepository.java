package com.example.trip.repository;

import com.example.trip.dto.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    // startDate로 여행상품 목록 조회
    // booking.html템플릿에서 달력의 날짜를 클릭하면 날짜에 등록된 여행상품 목록 표시하기 위한 메서드
    List<Trip> findByStartDate(LocalDate startDate);
}
