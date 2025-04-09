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

	@Embedded
	private MarketEvent marketEvent;

	private LocalDateTime updated_at;

	@PrePersist
	public void prePersist() {
		updated_at = LocalDateTime.now();
	}
}
