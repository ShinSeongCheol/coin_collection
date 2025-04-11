package com.seongcheol.coin_collection.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seongcheol.coin_collection.domain.Caution;

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
public class CautionDto {
    @JsonProperty("PRICE_FLUCTUATIONS")
    private Boolean priceFluctuations;
    @JsonProperty("TRADING_VOLUME_SOARING")
    private Boolean tradingVolumeSoaring;
    @JsonProperty("DEPOSIT_AMOUNT_SOARING")
    private Boolean tradingAmountSoaring;
    @JsonProperty("GLOBAL_PRICE_DIFFERENCES")
    private Boolean globalPriceDifferences;
    @JsonProperty("CONCENTRATION_OF_SMALL_ACCOUNTS")
    private Boolean concentrationOfSmallAccounts;
    
    public Caution toEntity() {
    	return Caution.builder()
    			.priceFluctuations(this.priceFluctuations)
    			.tradingVolumeSoaring(this.tradingVolumeSoaring)
    			.tradingAmountSoaring(this.tradingAmountSoaring)
    			.globalPriceDifferences(this.globalPriceDifferences)
    			.concentrationOfSmallAccounts(this.concentrationOfSmallAccounts)
    			.build();
    }
    
    public CautionDto toDto(Caution caution) {
    	return CautionDto.builder()
    			.priceFluctuations(caution.getPriceFluctuations())
    			.tradingVolumeSoaring(caution.getTradingVolumeSoaring())
    			.tradingAmountSoaring(caution.getTradingAmountSoaring())
    			.globalPriceDifferences(caution.getGlobalPriceDifferences())
    			.concentrationOfSmallAccounts(caution.getConcentrationOfSmallAccounts())
    			.build();
    }
}
