package com.seongcheol.coin_collection.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seongcheol.coin_collection.domain.Market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    private MarketEventDto marketEventDto;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Market toEntity() {
        return Market.builder()
        		.id(this.getId())
                .market(this.getMarket())
                .koreanName(this.getKoreanName())
                .englishName(this.getEnglishName())
                .marketEvent(this.getMarketEventDto().toEntity())
                .createdAt(this.getCreatedAt())
                .build();
    }

    public MarketDto toDto(Market market) {
        return MarketDto.builder()
                .id(market.getId())
                .market(market.getMarket())
                .koreanName(market.getKoreanName())
                .englishName(market.getEnglishName())
                .marketEventDto(marketEventDto.toDto(market.getMarketEvent()))
                .build();
    }
}
