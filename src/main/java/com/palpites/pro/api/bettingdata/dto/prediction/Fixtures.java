package com.palpites.pro.api.bettingdata.dto.prediction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class Fixtures{
    private Played played;
    private Wins wins;
    private Draws draws;
    private Loses loses;
}
