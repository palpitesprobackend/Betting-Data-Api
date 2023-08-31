package com.palpites.pro.api.bettingdata.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BettingDataDto {

    private String league;
    private String winner;
    private Integer goalsWinner;
    private String flagWinner;
    private String loser;
    private Integer goalsLoser;
    private String flagLoser;
    private String date;
    private String bookmaker;
    private String betPayment;
}
