package com.seongcheol.coin_collection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seongcheol.coin_collection.domain.Market;
import com.seongcheol.coin_collection.dto.MarketDto;
import com.seongcheol.coin_collection.service.CandleService;
import com.seongcheol.coin_collection.service.MarketService;

@RestController
@RequestMapping("/market")
public class MarketController {

	@Autowired
	MarketService marketService;
	
	@Autowired
	CandleService candleService;

	@GetMapping("/")
	public List<MarketDto> main() {
		return marketService.getMarketList();
	}
	
	@PostMapping("/update")
	public List<MarketDto> update() {
		return marketService.updateUpbitMarket();
	}
	
}
