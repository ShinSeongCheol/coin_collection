package com.seongcheol.coin_collection.domain;

import java.math.BigDecimal;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Candle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@ManyToOne
	@JoinColumn(name = "market_id")
	protected Market market;

	@Column
	@Comment("캔들 기준 시각(UTC 기준)")
	protected String candleDateTimeUtc;
	@Column
	@Comment("캔들 기준 시각(KST 기준)")
	protected String candleDateTimeKst;
	
	@Comment("시가")
	protected BigDecimal openingPrice;
	@Comment("고가")
	protected BigDecimal highPrice;
	@Comment("저가")
	protected BigDecimal lowPrice;
	@Comment("종가")
	protected BigDecimal tradePrice;
	@Comment("마지막 틱이 저장된 시각")
	protected Long timestamp;
	@Comment("누적 거래 금액")
	protected BigDecimal candleAccTradePrice;
	@Comment("누적 거래량")
	protected BigDecimal candleAccTradeVolume;
}
