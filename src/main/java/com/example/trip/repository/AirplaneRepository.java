package com.example.trip.repository;

import com.example.trip.subDto.Airplane;
import com.example.trip.subDto.Domestic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
}
