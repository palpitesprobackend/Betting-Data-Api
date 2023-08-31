package com.palpites.pro.api.bettingdata.dto.prediction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class Biggest{
    private Streak streak;
    private Wins wins;
    private Loses loses;
    private Goals goals;
}
