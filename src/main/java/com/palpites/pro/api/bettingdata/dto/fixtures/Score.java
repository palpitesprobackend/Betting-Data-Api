package com.palpites.pro.api.bettingdata.dto.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class Score{
    private Halftime halftime;
    private Fulltime fulltime;
    private Extratime extratime;
    private Penalty penalty;
}
