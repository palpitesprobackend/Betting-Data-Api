package com.palpites.pro.api.bettingdata.dto.bets;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseTipsData {
  private String advice;
  private String winner;
  private String flagWinner;
  private String loser;
  private String flagLoser;
  private String date;
  private String bookmaker;
  private List<Double> betPayment;
}
