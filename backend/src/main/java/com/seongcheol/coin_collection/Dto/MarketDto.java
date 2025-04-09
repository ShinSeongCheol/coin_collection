package com.seongcheol.coin_collection.Dto;

import com.seongcheol.coin_collection.Domain.Market;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarketDto {
    private Integer id;

    private String market;
    private String korean_name;
    private String english_name;

    private Boolean market_event_warning;
    private Boolean market_event_caution_price_fluctuations;
    private Boolean market_event_caution_trading_volume_soaring;
    private Boolean market_event_caution_trading_amount_soaring;
    private Boolean market_event_caution_price_differences;
    private Boolean market_event_caution_concentration_of_small_accounts;

    private LocalDateTime updated_at;

    public Market toEntity(MarketDto marketDto) {
        return Market.builder()
                .market(marketDto.getMarket())
                .korean_name(marketDto.getKorean_name())
                .english_name(marketDto.getEnglish_name())
                .market_event_warning(marketDto.getMarket_event_warning())
                .market_event_caution_price_fluctuations(marketDto.getMarket_event_caution_price_fluctuations())
                .market_event_caution_trading_volume_soaring(marketDto.getMarket_event_caution_trading_volume_soaring())
                .market_event_caution_trading_amount_soaring(marketDto.getMarket_event_caution_trading_amount_soaring())
                .market_event_caution_price_differences(marketDto.getMarket_event_caution_price_differences())
                .market_event_caution_concentration_of_small_accounts(marketDto.getMarket_event_caution_concentration_of_small_accounts())
                .build();
    }

    public MarketDto toDto(Market market) {
        return MarketDto.builder()
                .id(market.getId())
                .market(market.getMarket())
                .korean_name(market.getKorean_name())
                .english_name(market.getEnglish_name())
                .market_event_warning(market.getMarket_event_warning())
                .market_event_caution_price_fluctuations(market.getMarket_event_caution_price_fluctuations())
                .market_event_caution_trading_volume_soaring(market.getMarket_event_caution_trading_volume_soaring())
                .market_event_caution_trading_amount_soaring(market.getMarket_event_caution_trading_amount_soaring())
                .market_event_caution_price_differences(market.getMarket_event_caution_price_differences())
                .market_event_caution_concentration_of_small_accounts(market.getMarket_event_caution_concentration_of_small_accounts())
                .updated_at(market.getUpdated_at())
                .build();
    }
}
