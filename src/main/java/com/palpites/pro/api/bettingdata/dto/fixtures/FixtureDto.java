package com.palpites.pro.api.bettingdata.dto.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.Date;

@Getter
@JsonIgnoreProperties
public class FixtureDto {
    private int id;
    private Object referee;
    private String timezone;
    private Date date;
    private int timestamp;
    private Periods periods;
    private Venue venue;
    private Status status;
}
