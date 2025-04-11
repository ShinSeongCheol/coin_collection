package com.seongcheol.coin_collection.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.seongcheol.coin_collection.domain.Market;
import com.seongcheol.coin_collection.dto.CautionDto;
import com.seongcheol.coin_collection.dto.MarketDto;
import com.seongcheol.coin_collection.dto.MarketEventDto;
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

	public void updateUpbitMarket() {
		URI uri = UriComponentsBuilder.fromUriString("https://api.upbit.com/v1")
				.path("/market/all")
				.queryParam("is_details", "true")
				.build()
				.encode()
				.toUri();
		
		List<MarketDto> marketDtoList =  WebClient.builder()
				.baseUrl(uri.toString())
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
						return MarketDto.builder()
								.id(market.getId())
								.market(market.getMarket())
								.koreanName(market.getKoreanName())
								.englishName(market.getEnglishName())
								.marketEventDto(MarketEventDto.builder()
										.warning(market.getMarketEvent().getWarning())
										.cautionDto(CautionDto.builder()
												.priceFluctuations(market.getMarketEvent().getCaution().getPriceFluctuations())
												.tradingVolumeSoaring(market.getMarketEvent().getCaution().getTradingVolumeSoaring())
												.tradingAmountSoaring(market.getMarketEvent().getCaution().getTradingAmountSoaring())
												.globalPriceDifferences(market.getMarketEvent().getCaution().getGlobalPriceDifferences())
												.concentrationOfSmallAccounts(market.getMarketEvent().getCaution().getConcentrationOfSmallAccounts())
												.build()
												)
										.build()
										)
								.build()
								.toEntity();
					}else {
						return marketDto.toEntity();
					}
				})
				.toList();
		
		marketRepository.saveAll(marketList);
	}
	
}
