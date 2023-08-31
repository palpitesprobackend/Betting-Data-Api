package com.palpites.pro.api.bettingdata.dto.prediction;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@JsonIgnoreProperties
public class PredictionResponseDto {
    private String get;
    private Parameters parameters;
    private ArrayList<Object> errors;
    private int results;
    private Paging paging;
    private ArrayList<Response> response;
}




