package com.example.trip.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String goodsCode;       // 상품코드
    private String goodsName;       // 상품명
    private int baseQuantity;       // 기본수량
    private int minQuantity;        // 최소주문수량
    private int goodsPrice;         // 가격(개/원)
    private String goodsSize;       // 규격
    private String material;        // 재질
    private String productionTime;  // 제작기간
    private String goodsOrigin;     // 원산지
    private String goodsImageUrl;   // 상품 이미지

}
