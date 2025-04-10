package com.seongcheol.coin_collection.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;

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
	@Comment("업비트에서 제공중인 시장 정보")
	
	private String market;
	@Column
	@Comment("거래 대상 디지털 자산 한글명")
	private String koreanName;
	@Column
	@Comment("거래 대상 디지털 자산 영문명")
	private String englishName;

	@Embedded
	private MarketEvent marketEvent;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@PrePersist
	public void prePersist() {
		createdAt = LocalDateTime.now();
		updatedAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		updatedAt = LocalDateTime.now();
	}
}
