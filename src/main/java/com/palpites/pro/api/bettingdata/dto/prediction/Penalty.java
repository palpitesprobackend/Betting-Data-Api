package com.palpites.pro.api.bettingdata.dto.prediction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class Penalty{
    private Scored scored;
    private Missed missed;
    private int total;
    private Object home;
    private Object away;
}
