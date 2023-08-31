package com.palpites.pro.api.bettingdata.dto.prediction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@JsonIgnoreProperties
public class League{
    private int id;
    private String name;
    private String country;
    private String logo;
    private String flag;
    private int season;
    private String form;
    private Fixtures fixtures;
    private Goals goals;
    private Biggest biggest;
    private CleanSheet clean_sheet;
    private FailedToScore failed_to_score;
    private Penalty penalty;
    private ArrayList<Lineup> lineups;
    private Cards cards;
    private String round;
}
