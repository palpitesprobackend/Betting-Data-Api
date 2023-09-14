package com.palpites.pro.api.bettingdata.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.palpites.pro.api.bettingdata.dto.bets.BettingDataDto;
import com.palpites.pro.api.bettingdata.dto.bets.StandingsDto;

@FeignClient(name = "ApiFootBall", url = "http://localhost:3000/api")
public interface ApiFootBallClient {

    @GetMapping(value = "/data-tips")
    List<BettingDataDto> findBettingTips();

    @GetMapping(value = "/data-standings")
    List<StandingsDto> findStandings();
}
