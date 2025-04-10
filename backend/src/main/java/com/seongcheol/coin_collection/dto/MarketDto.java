package com.seongcheol.coin_collection.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seongcheol.coin_collection.domain.Market;
import com.seongcheol.coin_collection.domain.MarketEvent;

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
    private String koreanName;
    @JsonProperty("english_name")
    private String englishName;
    @JsonProperty("market_event")
    private MarketEvent marketEvent;

    private LocalDateTime updated_at;

    public Market toEntity() {
        return Market.builder()
        		.id(this.getId())
                .market(this.getMarket())
                .koreanName(this.getKoreanName())
                .englishName(this.getEnglishName())
                .marketEvent(this.getMarketEvent())
                .build();
    }

    public MarketDto toDto(Market market) {
        return MarketDto.builder()
                .id(market.getId())
                .market(market.getMarket())
                .koreanName(market.getKoreanName())
                .englishName(market.getEnglishName())
                .marketEvent(market.getMarketEvent())
                .build();
    }
}
