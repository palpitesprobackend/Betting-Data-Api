package com.palpites.pro.api.bettingdata.dto.bets;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class StandingResponseDto extends BaseStandingsDto {
    private Integer leagueId;
    private String leagueName;
    private String leagueLogo;
}
