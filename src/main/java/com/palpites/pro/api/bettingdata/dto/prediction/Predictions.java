package com.palpites.pro.api.bettingdata.dto.prediction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class Predictions{
    private Winner winner;
    private boolean win_or_draw;
    private String under_over;
    private Goals goals;
    private String advice;
    private Percent percent;
}
