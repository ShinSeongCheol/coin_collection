package com.seongcheol.coin_collection.domain;

import java.math.BigDecimal;

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
	
	private BigDecimal openingPrice;
	private BigDecimal highPrice;
	private BigDecimal lowPrice;
	private BigDecimal tradePrice;
	private Long timestamp;
	private BigDecimal candleAccTradePrice;
	private BigDecimal candleAccTradeVolume;
	private BigDecimal prevClosingPrice;
	private BigDecimal changePrice;
	private BigDecimal changeRate;
	private BigDecimal convertedTradePrice;
	
}
