package com.seongcheol.coin_collection.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seongcheol.coin_collection.Domain.Market;

public interface MarketRepository extends JpaRepository<Market, Integer>{
	List<Market> findAll();
	Market findByMarket(String id);
}
