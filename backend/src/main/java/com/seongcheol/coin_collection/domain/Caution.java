package com.seongcheol.coin_collection.domain;

import org.hibernate.annotations.Comment;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Builder
@ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Caution {
    @Comment("가격 급등락 경보 발령 여부")
    private Boolean priceFluctuations;
    @Comment("거래량 급등 경보 발령 여부")
    private Boolean tradingVolumeSoaring;
    @Comment("입금량 급등 경보 발령 여부")
    private Boolean tradingAmountSoaring;
    @Comment("가격 차이 경보 발령 여부")
    private Boolean globalPriceDifferences;
    @Comment("소수 계정 집중 경보 발령 여부")
    private Boolean concentrationOfSmallAccounts;
}
