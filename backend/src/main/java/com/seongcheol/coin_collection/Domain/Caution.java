package com.seongcheol.coin_collection.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Caution {
    @JsonProperty("PRICE_FLUCTUATIONS")
    private Boolean price_fluctuations;
    @JsonProperty("TRADING_VOLUME_SOARING")
    private Boolean trading_volume_soaring;
    @JsonProperty("DEPOSIT_AMOUNT_SOARING")
    private Boolean trading_amount_soaring;
    @JsonProperty("GLOBAL_PRICE_DIFFERENCES")
    private Boolean global_price_differences;
    @JsonProperty("CONCENTRATION_OF_SMALL_ACCOUNTS")
    private Boolean concentration_of_small_accounts;
}
