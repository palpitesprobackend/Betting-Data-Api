package com.palpites.pro.api.bettingdata.dto.prediction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class Average{
    private String home;
    private String away;
    private String total;
}
