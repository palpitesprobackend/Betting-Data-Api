package com.palpites.pro.api.bettingdata.dto.prediction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@JsonIgnoreProperties
public class Response{
    private Predictions predictions;
    private League league;
    private Teams teams;
    private Comparison comparison;
    private ArrayList<H2h> h2h;
}
