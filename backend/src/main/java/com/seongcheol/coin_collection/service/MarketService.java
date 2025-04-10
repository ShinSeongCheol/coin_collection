package com.seongcheol.coin_collection.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.seongcheol.coin_collection.domain.Market;
import com.seongcheol.coin_collection.dto.MarketDto;
import com.seongcheol.coin_collection.repository.MarketRepository;

@Service
public class MarketService {
	
	@Autowired
	MarketRepository marketRepository;
	
	public List<Market> getMarketList() {
		List<Market> marketList = marketRepository.findAll();

		return marketList;
	}
	
	public Market getMarket() {
		Optional<Market> optionalMarket = marketRepository.findByMarket("market");

		return optionalMarket.get();
	}

	public void getUpbitMarket() {
		List<MarketDto> marketDtoList =  WebClient.builder()
				.baseUrl("https://api.upbit.com/v1/market/all?is_details=true")
				.build()
				.get()
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToFlux(MarketDto.class)
				.collectList()
				.block();
		
		
		List<Market> marketList =  marketDtoList.stream()
				.map(marketDto -> {
					Optional<Market> optionalMarket = marketRepository.findByMarket(marketDto.getMarket());
					if(optionalMarket.isPresent()) {
						Market market = optionalMarket.get();
						MarketDto updatedMarketDto = MarketDto.builder()
								.id(market.getId())
								.market(market.getMarket())
								.koreanName(market.getKoreanName())
								.englishName(market.getEnglishName())
								.marketEvent(market.getMarketEvent())
								.build();
						
						return updatedMarketDto.toEntity();
					}else {
						return marketDto.toEntity();
					}
				})
				.toList();
		
		marketRepository.saveAll(marketList);
	}
	
}
