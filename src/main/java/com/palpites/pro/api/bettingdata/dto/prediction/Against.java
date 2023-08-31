package com.palpites.pro.api.bettingdata.dto.prediction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class Against{
    private int total;
    private String average;
    private Minute minute;
    private int home;
    private int away;
}
