package com.seongcheol.coin_collection.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class MarketEvent {
    @JsonProperty("warning")
    private Boolean warning;
    @Embedded
    @JsonProperty("caution")
    private Caution caution;
}
