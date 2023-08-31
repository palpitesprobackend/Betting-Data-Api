package com.palpites.pro.api.bettingdata.dto.prediction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class Status{
    @JsonProperty("long")
    private String mylong;
    @JsonProperty("short")
    private String myshort;
    private int elapsed;
}
