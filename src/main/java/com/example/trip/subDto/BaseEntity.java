package com.example.trip.subDto;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// abstract : 추상클래스, 반드시 상속받아야 하는 클래스
@Data
public abstract class BaseEntity {
    private String title;
    private String link;
    private String image;
    private int lprice;
    private String mallName;
    private String category1;
    private String category2;
    private String category3;
    

}
