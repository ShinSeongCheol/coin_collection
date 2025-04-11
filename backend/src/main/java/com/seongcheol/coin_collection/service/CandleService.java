package com.seongcheol.coin_collection.service;


import java.net.URI;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.seongcheol.coin_collection.domain.DayCandle;
import com.seongcheol.coin_collection.domain.Market;
import com.seongcheol.coin_collection.dto.DayCandleDto;
import com.seongcheol.coin_collection.repository.CandleRepository;
import com.seongcheol.coin_collection.repository.MarketRepository;

@Service
public class CandleService {
	
	@Autowired
	private MarketRepository marketRepository;
	
	@Autowired
	private CandleRepository candleRepository;
	
	public List<DayCandleDto> getDayCandleDtoList() {
		return candleRepository.findAll().stream().map(dayCandle -> {
					return DayCandleDto.builder().build().toDto(dayCandle);
				}).toList();
	}
	
	public List<DayCandleDto> updateDayCandle() {
		
		List<Market> marketList =  marketRepository.findAll();
		
		List<DayCandle> dayCandleList = marketList.stream()
				.map(market -> {
					
					DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
					LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
					localDateTime = LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDayOfMonth(), 0, 0, 0);
			
					URI uri = UriComponentsBuilder
						.fromUriString("https://api.upbit.com/v1")
						.path("/candles/days")
						.queryParam("market", market.getMarket())
						.queryParam("to", localDateTime.format(dateTimeFormatter))
						.queryParam("count", "1")
						.queryParam("converting_price_unit", "KRW")
						.build()
						.encode()
						.toUri();
					
			
					DayCandleDto dayCandleDto =  WebClient.builder()
						.baseUrl(uri.toString())
						.build()
						.get()
						.accept(MediaType.APPLICATION_JSON)
						.retrieve()
						.bodyToFlux(DayCandleDto.class)
						.delayElements(Duration.ofMillis(200))
						.collectList()
						.block()
						.get(0);
			
					return dayCandleDto.toEntity(market);
		}).toList();
		
		return candleRepository.saveAll(dayCandleList).stream().map(dayCandle -> {
			return DayCandleDto.builder().build().toDto(dayCandle);
		}).toList();
	}

}
