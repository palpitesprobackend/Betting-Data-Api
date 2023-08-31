package com.palpites.pro.api.bettingdata.dto.prediction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class Yellow{
    @JsonProperty("0-15")
    private _015 _015;
    @JsonProperty("16-30")
    private _1630 _1630;
    @JsonProperty("31-45")
    private _3145 _3145;
    @JsonProperty("46-60")
    private _4660 _4660;
    @JsonProperty("61-75")
    private _6175 _6175;
    @JsonProperty("76-90")
    private _7690 _7690;
    @JsonProperty("91-105")
    private _91105 _91105;
    @JsonProperty("106-120")
    private _106120 _106120;
    @JsonProperty("")
    private _106120 vazio;
}
