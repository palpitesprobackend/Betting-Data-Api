package com.palpites.pro.api.bettingdata.dto.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class ResponseDto {
    @JsonProperty("fixture")
    private FixtureDto fixtureDto;
    private League league;
    private Teams teams;
    private Goals goals;
    private Score score;
}
