package com.palpites.pro.api.bettingdata.dto.bets;

import java.util.List;
import lombok.Data;

@Data
public class BettingDataDto {
    private Integer leagueId;
    private String leagueName;
    private  List<TipsDataDto> tips;
}
