package com.seongcheol.coin_collection.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seongcheol.coin_collection.Domain.Market;
import com.seongcheol.coin_collection.Service.MarketService;

@RestController
public class MarketController {
	
	@Autowired
	MarketService marketService;

	@GetMapping("/")
	public List<Market> main() {
		List<Market> marketList = marketService.getMarketList();
		return marketList;
	}
	
}
