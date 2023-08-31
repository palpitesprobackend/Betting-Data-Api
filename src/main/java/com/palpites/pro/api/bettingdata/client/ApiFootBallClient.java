package com.palpites.pro.api.bettingdata.client;

import com.palpites.pro.api.bettingdata.dto.RootTestDto;
import com.palpites.pro.api.bettingdata.dto.fixtures.FixtureResponseDto;
import com.palpites.pro.api.bettingdata.dto.prediction.PredictionResponseDto;
import feign.RequestLine;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name = "ApiFootBall", url = "https://v3.football.api-sports.io")
public interface ApiFootBallClient {

    @GetMapping(value = "/fixtures")
    FixtureResponseDto findFixture(@RequestHeader("x-rapidapi-key") String apiKey,
                                   @RequestParam("league") int league,
                                   @RequestParam("season") int season,
                                   @RequestParam("round") String round,
                                   @RequestParam("timezone") String timezone);

    @GetMapping(value = "/predictions")
    PredictionResponseDto findPrediction(@RequestHeader("x-rapidapi-key") String apiKey,
                                         @RequestParam("fixture") int fixture);

    @RequestLine("GET /{cep}/json/")
    RootTestDto findCep(@Param("cep") String cep);

//    @RequestLine("GET /users/{userId}")
//    UserInfo getUserInfo(@Param("userId") String userId);
}
