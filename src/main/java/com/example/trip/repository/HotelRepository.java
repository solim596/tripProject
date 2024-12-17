package com.example.trip.repository;

import com.example.trip.subDto.Domestic;
import com.example.trip.subDto.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
