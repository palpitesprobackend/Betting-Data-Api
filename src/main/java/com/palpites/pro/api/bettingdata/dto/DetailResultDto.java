package com.palpites.pro.api.bettingdata.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailResultDto {
    private Integer goalsWinner;
    private Integer goalsConcededWinner;
    //ESCANTEIO DO VENCEDOR
    private Integer cornersWinner;
    private Integer yellowCardsWinner;
    private Integer goalsLoser;
    private Integer goalsConcededLoser;
    //ESCANTEIO DO PERDEDOR
    private Integer cornersLoser;
    private Integer yellowCardsLoser;
}
