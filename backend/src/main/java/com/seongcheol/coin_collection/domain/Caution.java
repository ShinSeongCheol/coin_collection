package com.seongcheol.coin_collection.domain;

import org.hibernate.annotations.Comment;

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
    @Comment("가격 급등락 경보 발령 여부")
    private Boolean price_fluctuations;
    @JsonProperty("TRADING_VOLUME_SOARING")
    @Comment("거래량 급등 경보 발령 여부")
    private Boolean trading_volume_soaring;
    @JsonProperty("DEPOSIT_AMOUNT_SOARING")
    @Comment("입금량 급등 경보 발령 여부")
    private Boolean trading_amount_soaring;
    @JsonProperty("GLOBAL_PRICE_DIFFERENCES")
    @Comment("가격 차이 경보 발령 여부")
    private Boolean global_price_differences;
    @JsonProperty("CONCENTRATION_OF_SMALL_ACCOUNTS")
    @Comment("소수 계정 집중 경보 발령 여부")
    private Boolean concentration_of_small_accounts;
}
