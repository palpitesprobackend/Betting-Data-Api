package com.palpites.pro.api.bettingdata.dto.bets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseStandingsDto {
    private Integer teamId;
    private Integer ranking;
    private String nameTeam;
    private String flag;
    private Integer points;
    private Integer playedTot;
    private Integer winTot;
    private Integer drawTot;
    private Integer loseTot;
    private Integer sg;
    private Integer playedHome;
    private Integer winHome;
    private Integer drawHome;
    private Integer loseHome;
    private Integer playedAway;
    private Integer winAway;
    private Integer drawAway;
    private Integer loseAway;
}