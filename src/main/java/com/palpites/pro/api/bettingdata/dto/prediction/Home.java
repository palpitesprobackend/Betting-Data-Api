package com.palpites.pro.api.bettingdata.dto.prediction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class Home{
    private int id;
    private String name;
    private String logo;
    private Last5 last_5;
    private League league;
    private boolean winner;
}
