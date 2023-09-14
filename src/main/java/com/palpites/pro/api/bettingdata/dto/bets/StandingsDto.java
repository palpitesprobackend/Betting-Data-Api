package com.palpites.pro.api.bettingdata.dto.bets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StandingsDto {
    private Integer teamId;
    private Integer ranking;
    private String nameTeam;
    private String flag;
    private Integer points;
    private Integer playedTot;
    private Integer winTot;
    private Integer drawTot;
    private Integer loseTot;
    private Integer playedHome;
    private Integer winHome;
    private Integer drawHome;
    private Integer loseHome;
    private Integer playedAway;
    private Integer winAway;
    private Integer drawAway;
    private Integer loseAway;
}