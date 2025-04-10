package com.seongcheol.coin_collection.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
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
	private Double openingPrice;
	@JsonProperty("high_price")
	private Double highPrice;
	@JsonProperty("low_price")
	private Double lowPrice;
	@JsonProperty("trade_price")
	private Double tradePrice;
	@JsonProperty("timestamp")
	private Long timestamp;
	@JsonProperty("candle_acc_trade_price")
	private Double candleAccTradePrice;
	@JsonProperty("candle_acc_trade_volume")
	private Double candleAccTradeVolume;
	@JsonProperty("prev_closing_price")
	private Double prevClosingPrice;
	@JsonProperty("change_price")
	private Double changePrice;
	@JsonProperty("change_rate")
	private Double changeRate;
	@JsonProperty("converted_trade_price")
	private Double convertedTradePrice;
	
	
}
