package com.seongcheol.coin_collection.domain;

import java.math.BigDecimal;

import org.hibernate.annotations.Comment;

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
	@Comment("종목 코드")
	private String market;
	@Column
	@Comment("캔들 기준 시각(UTC 기준)")
	private String candleDateTimeUtc;
	@Column
	@Comment("캔들 기준 시각(KST 기준)")
	private String candleDateTimeKst;
	
	@Comment("시가")
	private BigDecimal openingPrice;
	@Comment("고가")
	private BigDecimal highPrice;
	@Comment("저가")
	private BigDecimal lowPrice;
	@Comment("종가")
	private BigDecimal tradePrice;
	@Comment("마지막 틱이 저장된 시각")
	private Long timestamp;
	@Comment("누적 거래 금액")
	private BigDecimal candleAccTradePrice;
	@Comment("누적 거래량")
	private BigDecimal candleAccTradeVolume;
	@Comment("전일 종가(UTC 0시 기준)")
	private BigDecimal prevClosingPrice;
	@Comment("전일 종가 대비 변화 금액")
	private BigDecimal changePrice;
	@Comment("전일 종가 대비 변화량")
	private BigDecimal changeRate;
	@Comment("종가 환산 화폐 단위로 환산된 가격")
	private BigDecimal convertedTradePrice;
	
}
