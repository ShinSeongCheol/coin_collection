package com.seongcheol.coin_collection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seongcheol.coin_collection.domain.DayCandle;

public interface CandleRepository extends JpaRepository<DayCandle, Integer>{

}
