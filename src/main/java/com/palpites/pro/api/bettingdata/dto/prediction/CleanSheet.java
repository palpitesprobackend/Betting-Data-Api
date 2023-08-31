package com.palpites.pro.api.bettingdata.dto.prediction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class CleanSheet{
    private int home;
    private int away;
    private int total;
}
