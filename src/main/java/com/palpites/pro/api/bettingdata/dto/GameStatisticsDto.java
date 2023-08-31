package com.palpites.pro.api.bettingdata.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameStatisticsDto {
    private Integer goalsWinner;
    private Integer goalsLoser;
    private Integer goalKicksWinner;
    private Integer goalKicksLoser;
    private Integer committedFaultsWinner;
    private Integer committedFaultsLoser;
    private Integer yellowCardsWinner;
    private Integer yellowCardsLoser;
    private Integer more;
}
