package com.palpites.pro.api.bettingdata.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataCarouselResponseDto {
    private String league;
    private String winner;
    private Integer goalsWinner;
    private String flagWinner;
    private String loser;
    private Integer goalsLoser;
    private String flagLoser;
}
