package com.example.trip.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long itemId;
    private String title;
    private LocalDate startDate;    // 출발일
    private BigDecimal totalPrice;  // 총금액
    private int numPeople;          // 총인원
    private String imageUrl;        // 이미지
    @CreationTimestamp
    private LocalDate createDate;   // 예약한 날짜
    @ManyToOne
    private Trip trip;              // 여행상품 1개당 많은 예약이 될 수 있음.
}
