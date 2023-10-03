package com.palpites.pro.api.bettingdata.dto.bets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BettingDataRespDto extends BaseTipsData{
  private String nameLeague;
}
