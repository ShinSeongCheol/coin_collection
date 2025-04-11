package com.seongcheol.coin_collection.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seongcheol.coin_collection.domain.DayCandle;
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
public class DayCandleDto {

	
	private Integer id;
	
	@JsonProperty("market")
	private String market;
	@JsonProperty("candle_date_time_utc")
	private String candleDateTimeUtc;
	@JsonProperty("candle_date_time_kst")
	private String candleDateTimeKst;
	
	@JsonProperty("opening_price")
	private BigDecimal openingPrice;
	@JsonProperty("high_price")
	private BigDecimal highPrice;
	@JsonProperty("low_price")
	private BigDecimal lowPrice;
	@JsonProperty("trade_price")
	private BigDecimal tradePrice;
	@JsonProperty("timestamp")
	private Long timestamp;
	@JsonProperty("candle_acc_trade_price")
	private BigDecimal candleAccTradePrice;
	@JsonProperty("candle_acc_trade_volume")
	private BigDecimal candleAccTradeVolume;
	@JsonProperty("prev_closing_price")
	private BigDecimal prevClosingPrice;
	@JsonProperty("change_price")
	private BigDecimal changePrice;
	@JsonProperty("change_rate")
	private BigDecimal changeRate;
	@JsonProperty("converted_trade_price")
	private BigDecimal convertedTradePrice;
	
	public DayCandle toEntity(Market market) {
		return DayCandle.builder()
				.market(market)
				.candleDateTimeUtc(this.candleDateTimeUtc)
				.candleDateTimeKst(this.candleDateTimeKst)
				.openingPrice(this.openingPrice)
				.highPrice(this.highPrice)
				.lowPrice(this.lowPrice)
				.tradePrice(this.tradePrice)
				.timestamp(this.timestamp)
				.candleAccTradePrice(this.candleAccTradePrice)
				.candleAccTradeVolume(this.candleAccTradeVolume)
				.prevClosingPrice(this.prevClosingPrice)
				.changePrice(this.changePrice)
				.changeRate(this.changeRate)
				.convertedTradePrice(this.convertedTradePrice)
				.build();
	}
	
	public DayCandleDto toDto(DayCandle dayCandle) {
		return DayCandleDto.builder()
				.id(dayCandle.getId())
				.market(dayCandle.getMarket().getMarket())
				.candleDateTimeUtc(dayCandle.getCandleDateTimeUtc())
				.candleDateTimeKst(dayCandle.getCandleDateTimeKst())
				.openingPrice(dayCandle.getOpeningPrice())
				.highPrice(dayCandle.getHighPrice())
				.lowPrice(dayCandle.getLowPrice())
				.tradePrice(dayCandle.getTradePrice())
				.timestamp(dayCandle.getTimestamp())
				.candleAccTradePrice(dayCandle.getCandleAccTradePrice())
				.candleAccTradeVolume(dayCandle.getCandleAccTradeVolume())
				.prevClosingPrice(dayCandle.getPrevClosingPrice())
				.changePrice(dayCandle.getChangePrice())
				.changeRate(dayCandle.getChangeRate())
				.convertedTradePrice(dayCandle.getConvertedTradePrice())
				.build();
	}
}
