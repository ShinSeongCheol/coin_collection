package com.seongcheol.coin_collection.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seongcheol.coin_collection.domain.MarketEvent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MarketEventDto {
    @JsonProperty("warning")
    private Boolean warning;
    @JsonProperty("caution")
    private CautionDto cautionDto;
    
    public MarketEvent toEntity() {
    	return MarketEvent.builder()
    			.warning(this.warning)
    			.caution(this.cautionDto.toEntity())
    			.build();
    }
    
    public MarketEventDto toDto(MarketEvent marketEvent) {
    	return MarketEventDto.builder()
    			.warning(marketEvent.getWarning())
    			.cautionDto(cautionDto.toDto(marketEvent.getCaution()))
    			.build();
    }
}
