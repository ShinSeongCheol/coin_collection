package com.seongcheol.coin_collection.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.seongcheol.coin_collection.service.CandleService;

@Component
public class CandleScheduler {
	
	@Autowired
	private CandleService candleService;
	
	@Scheduled(cron = "10 0 9 * * *")
	public void updateDayCandle() {
		candleService.updateDayCandle();
	}
	
}
