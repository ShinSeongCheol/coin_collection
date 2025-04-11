package com.seongcheol.coin_collection.domain;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;

@Getter
@Builder
@ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class MarketEvent {
    @Comment("업비트 시장경보 > 유의종목 지정 여부")
    private Boolean warning;
    @Embedded
    private Caution caution;
}
