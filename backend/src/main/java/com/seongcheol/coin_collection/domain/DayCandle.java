package com.seongcheol.coin_collection.domain;

import java.math.BigDecimal;

import org.hibernate.annotations.Comment;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue(value = "day_candle")
public class DayCandle extends Candle {
	
	@Comment("전일 종가(UTC 0시 기준)")
	private BigDecimal prevClosingPrice;
	@Comment("전일 종가 대비 변화 금액")
	private BigDecimal changePrice;
	@Comment("전일 종가 대비 변화량")
	private BigDecimal changeRate;
	@Comment("종가 환산 화폐 단위로 환산된 가격")
	private BigDecimal convertedTradePrice;
	
}
