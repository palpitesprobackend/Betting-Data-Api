package com.palpites.pro.api.bettingdata.dto.prediction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class H2h{
    private String home;
    private String away;
    private Fixture fixture;
    private League league;
    private Teams teams;
    private Goals goals;
    private Score score;
}
