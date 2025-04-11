package com.seongcheol.coin_collection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seongcheol.coin_collection.domain.Market;
import com.seongcheol.coin_collection.service.CandleService;
import com.seongcheol.coin_collection.service.MarketService;

@RestController
public class MarketController {

	@Autowired
	MarketService marketService;
	
	@Autowired
	CandleService candleService;

	@GetMapping("/")
	public List<Market> main() {
		List<Market> marketList = marketService.getMarketList();
		return marketList;
	}
	
	@GetMapping("/update")
	public void update() {
		marketService.registerUpbitMarket();
		candleService.getDayCandle();
	}
	
}
