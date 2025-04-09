package com.seongcheol.coin_collection.Service;

import com.seongcheol.coin_collection.Domain.Market;
import com.seongcheol.coin_collection.Dto.MarketDto;
import com.seongcheol.coin_collection.Repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

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

	public void getMarketAll() {
		WebClient.builder()
				.baseUrl("https://api.upbit.com/v1/market/all?is_details=true")
				.build()
				.get()
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToFlux(MarketDto.class)
				.subscribe(marketDto -> {
					if (!marketRepository.existsByMarket(marketDto.getMarket())) {
						marketRepository.save(marketDto.toEntity(marketDto));
					};
				});
	}
	
}
