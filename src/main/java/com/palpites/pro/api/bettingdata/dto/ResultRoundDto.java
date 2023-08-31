package com.palpites.pro.api.bettingdata.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultRoundDto {
    private String league;
    private String winner;
    private Integer goalsWinner;
    private String flagWinner;
    private String loser;
    private Integer goalsLoser;
    private String flagLoser;
    private String date;
    private DetailResultDto detail;
}
