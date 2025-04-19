package com.seongcheol.coin_collection.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class CandleDto {
	
	protected Long id;
	
	@JsonProperty("market")
	protected String market;
	@JsonProperty("candle_date_time_utc")
	protected String candleDateTimeUtc;
	@JsonProperty("candle_date_time_kst")
	protected String candleDateTimeKst;
	
	@JsonProperty("opening_price")
	protected BigDecimal openingPrice;
	@JsonProperty("high_price")
	protected BigDecimal highPrice;
	@JsonProperty("low_price")
	protected BigDecimal lowPrice;
	@JsonProperty("trade_price")
	protected BigDecimal tradePrice;
	@JsonProperty("timestamp")
	protected Long timestamp;
	@JsonProperty("candle_acc_trade_price")
	protected BigDecimal candleAccTradePrice;
	@JsonProperty("candle_acc_trade_volume")
	protected BigDecimal candleAccTradeVolume;

}
