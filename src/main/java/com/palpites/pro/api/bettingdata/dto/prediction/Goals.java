package com.palpites.pro.api.bettingdata.dto.prediction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class Goals{
    private String home;
    private String away;
    @JsonProperty("for")
    private For myfor;
    private Against against;
}
