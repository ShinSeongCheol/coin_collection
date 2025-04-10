package com.seongcheol.coin_collection.service;


import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.seongcheol.coin_collection.domain.Market;
import com.seongcheol.coin_collection.dto.DayCandleDto;
import com.seongcheol.coin_collection.repository.MarketRepository;

@Service
public class CandleService {
	
	@Autowired
	private MarketRepository marketRepository;
	
	public void getDayCandle() {
		
		List<Market> marketList =  marketRepository.findAll();
		marketList.stream().map(market -> {
			
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("");
			LocalDateTime currentTime = LocalDateTime.now();
			
			URI uri = UriComponentsBuilder
					.fromUriString("https://api.upbit.com/v1")
					.path("/candles/days")
					.queryParam("market", market.getMarket())
					.queryParam("to", "")
					.queryParam("count", "1")
					.queryParam("converting_price_unit", "")
					.build()
					.encode()
					.toUri();
			
			List<DayCandleDto> dayCandleDtoList =  WebClient.builder()
					.baseUrl(uri.toString())
					.build()
					.get()
					.accept(MediaType.APPLICATION_JSON)
					.retrieve()
					.bodyToFlux(DayCandleDto.class)
					.collectList()
					.block();
			
			
			return market;
		});
		
		
		System.out.println(dayCandleDtoList.toString());
	}

}
