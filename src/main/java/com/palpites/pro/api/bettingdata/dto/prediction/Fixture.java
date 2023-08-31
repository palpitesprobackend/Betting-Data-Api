package com.palpites.pro.api.bettingdata.dto.prediction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.Date;

@Getter
@JsonIgnoreProperties
public class Fixture{
    private int id;
    private String referee;
    private String timezone;
    private Date date;
    private int timestamp;
    private Periods periods;
    private Venue venue;
    private Status status;
}
