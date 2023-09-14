package com.palpites.pro.api.bettingdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BettingDataService {

//    @Value("${Api-football.LeagueId}")
//    private Integer leagueId;
//    @Value("${Api-football.TimeZone}")
//    private String timeZone;
//    @Value("${Api-football.x-rapidapi-key}")
//    private String apiKey;
//    @Value("${Api-football.urlApiFootball}")
//    private String url;

//    private final ApiFootBallClient client;

    public String findDataApiFootball() {
//        FixtureResponseDto fixtureResponseDto = client.findFixture(apiKey,leagueId,2023,"Regular Season - 22", timeZone);
//        for (ResponseDto responseDto: fixtureResponseDto.getResponseDto()) {
//            client.findPrediction(apiKey, responseDto.getFixtureDto().getId());
//        }

        return "";
    }
}
