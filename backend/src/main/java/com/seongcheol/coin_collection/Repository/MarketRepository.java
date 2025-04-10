package com.seongcheol.coin_collection.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seongcheol.coin_collection.Domain.Market;

public interface MarketRepository extends JpaRepository<Market, Integer>{
	List<Market> findAll();
	Optional<Market> findByMarket(String market);
	boolean existsByMarket(String market);
}
