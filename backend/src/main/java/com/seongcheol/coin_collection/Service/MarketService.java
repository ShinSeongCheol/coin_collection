package com.seongcheol.coin_collection.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seongcheol.coin_collection.Domain.Market;
import com.seongcheol.coin_collection.Repository.MarketRepository;

@Service
public class MarketService {
	
	@Autowired
	MarketRepository marketRepository;
	
	public List<Market> getMarketList() {
		List<Market> marketList = marketRepository.findAll();

		return marketList;
	}
	
	public Market getMarket() {
		Market market = marketRepository.findByMarket("market");

		return market;
	}
	
}
