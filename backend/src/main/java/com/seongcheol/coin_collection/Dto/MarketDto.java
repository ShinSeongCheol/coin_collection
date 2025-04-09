package com.seongcheol.coin_collection.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seongcheol.coin_collection.Domain.Market;
import com.seongcheol.coin_collection.Domain.MarketEvent;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MarketDto {
    private Integer id;

    @JsonProperty("market")
    private String market;
    @JsonProperty("korean_name")
    private String korean_name;
    @JsonProperty("english_name")
    private String english_name;
    @JsonProperty("market_event")
    private MarketEvent market_event;

    private LocalDateTime updated_at;

    public Market toEntity(MarketDto marketDto) {
        return Market.builder()
                .market(marketDto.getMarket())
                .korean_name(marketDto.getKorean_name())
                .english_name(marketDto.getEnglish_name())
                .marketEvent(marketDto.getMarket_event())
                .build();
    }

    public MarketDto toDto(Market market) {
        return MarketDto.builder()
                .id(market.getId())
                .market(market.getMarket())
                .korean_name(market.getKorean_name())
                .english_name(market.getEnglish_name())
                .market_event(market.getMarketEvent())
                .build();
    }
}
