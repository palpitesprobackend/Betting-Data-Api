package com.palpites.pro.api.bettingdata.dto.bets;

import java.util.List;
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
public class StandingsDataDto {
    private String leagueName;
    private String leagueLogo;
    private Integer leagueId;
    private Integer round;
    private List<StandingDto> dataStanding;
}