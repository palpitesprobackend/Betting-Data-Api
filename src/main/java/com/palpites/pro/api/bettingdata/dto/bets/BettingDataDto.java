package com.palpites.pro.api.bettingdata.dto.bets;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BettingDataDto {
  private String nameLeague;
  private String advice;
  private String winner;
  private String flagWinner;
  private String loser;
  private String flagLoser;
  private String date;
  private String bookmaker;
  private List<Double> betPayment;
}
