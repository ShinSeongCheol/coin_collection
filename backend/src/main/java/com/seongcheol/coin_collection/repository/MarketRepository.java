package com.seongcheol.coin_collection.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seongcheol.coin_collection.domain.Market;

public interface MarketRepository extends JpaRepository<Market, Integer>{
	Optional<Market> findByMarket(String market);
	boolean existsByMarket(String market);
}
