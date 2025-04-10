package com.seongcheol.coin_collection.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DayCandle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String market;
	@Column
	private String candleDateTimeUtc;
	@Column
	private String candleDateTimeKst;
	
	private Double opening_price;
	private Double high_price;
	private Double low_price;
	private Double trade_price;
	private Long timestamp;
	private Double candleAccTradePrice;
	private Double candleAccTradeVolume;
	private Double prevClosingPrice;
	private Double changePrice;
	private Double changeRate;
	private Double convertedTradePrice;
	
}
