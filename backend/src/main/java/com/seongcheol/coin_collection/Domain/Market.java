package com.seongcheol.coin_collection.Domain;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Market {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String market;
	@Column
	private String korean_name;
	@Column
	private String english_name;
	
	private Boolean market_event_warning;
	private Boolean market_event_caution_price_fluctuations;
	private Boolean market_event_caution_trading_volume_soaring;
	private Boolean market_event_caution_trading_amount_soaring;
	private Boolean market_event_caution_price_differences;
	private Boolean market_event_caution_concentration_of_small_accounts;
	
	private LocalDateTime updated_at;
	
}
