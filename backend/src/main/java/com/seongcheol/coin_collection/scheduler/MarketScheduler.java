package com.seongcheol.coin_collection.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.seongcheol.coin_collection.service.MarketService;

@Component
public class MarketScheduler {

	@Autowired
	private MarketService marketService;
	
	@Scheduled(cron = "* * 0 * * *")
	public void getUpbitMarket() {
		marketService.registerUpbitMarket();
	}
	
}
