package com.seongcheol.coin_collection.Scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CandleScheduler {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Scheduled(cron = "*/10 * * * * *")
	public void run() {
		logger.info("run");
	}
	
}
