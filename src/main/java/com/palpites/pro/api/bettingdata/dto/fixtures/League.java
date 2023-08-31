package com.palpites.pro.api.bettingdata.dto.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class League{
    private int id;
    private String name;
    private String country;
    private String logo;
    private String flag;
    private int season;
    private String round;
}
