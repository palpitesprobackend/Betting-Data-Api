package com.palpites.pro.api.bettingdata.controller;

import com.palpites.pro.api.bettingdata.client.ApiFootBallClient;
import com.palpites.pro.api.bettingdata.dto.*;
import com.palpites.pro.api.bettingdata.dto.response.BettingDataResponseDto;
import com.palpites.pro.api.bettingdata.dto.response.DataCarouselResponseDto;
import com.palpites.pro.api.bettingdata.service.BettingDataService;
import feign.Feign;
import feign.gson.GsonDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BettingDataController {
//    @Value("${Api-football.LeagueId}")
//    private Integer leagueId;
//    @Value("${Api-football.TimeZone}")
//    private String timeZone;
//    @Value("${Api-football.x-rapidapi-key}")
//    private String apiKey;
//    @Value("${Api-football.urlApiFootball}")
//    private String url;
//    private final BettingDataService service;

    private final ApiFootBallClient client;

    @Autowired
    public BettingDataController (ApiFootBallClient client) {
        this.client = client;
    }

//    @GetMapping("/tips")
//    public ResponseEntity<BettingDataResponseDto<BettingDataDto>> findTipsData() {
//
//        BettingDataResponseDto responseDto = BettingDataResponseDto.builder()
//                .data(service.findDataApiFootball())
//                .build();
//        return ResponseEntity.ok(responseDto);
//    }

//    @GetMapping("/")
//    public String findTipsDatas() {
//        return client
//                .findFixture("ca857d05544960a3081c65b94fa9b489",71,2023,"Regular Season - 22", "America/Sao_Paulo")
//                .toString();
//    }

    @GetMapping("/")
    public String findTipsDatas() {

        ApiFootBallClient client = Feign.builder()
                .decoder(new GsonDecoder()) // Utiliza o Gson para decodificar a resposta JSON
                .target(ApiFootBallClient.class, "viacep.com.br/ws");

        var result = client.
//        var result = client
//                .findCep("53150400")
//                .bairro;
        return "result.toString()";
    }

    @GetMapping("/test")
    public ResponseEntity<String> testandoApi() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v3.football.api-sports.io/predictions?fixture=1005840"))
                .header("x-rapidapi-key", "ca857d05544960a3081c65b94fa9b489")
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        int statusCode = response.statusCode();
        String responseBody = response.body();
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/carousel")
    public ResponseEntity<BettingDataResponseDto<DataCarouselResponseDto>> findDataCarousel() {
        List<DataCarouselResponseDto> dataCarouselDtoList = new ArrayList<>();
        DataCarouselResponseDto bettingDataDto = DataCarouselResponseDto.builder()
                .league("Serie A")
                .winner("Atletico-MG")
                .goalsWinner(3)
                .flagWinner("https://media-1.api-sports.io/football/teams/1062.png")
                .loser("Vasco DA Gama")
                .goalsLoser(0)
                .flagLoser("https://media-1.api-sports.io//football//teams//133.png")
                .build();
        dataCarouselDtoList.add(bettingDataDto);

        BettingDataResponseDto responseDto = BettingDataResponseDto.builder()
                .data(dataCarouselDtoList)
                .build();
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/game-statistics")
    public ResponseEntity<BettingDataResponseDto<GameStatisticsDto>> findGameStatistics() {
        GameStatisticsDto gameStatisticsDto = GameStatisticsDto.builder()
                .goalsWinner(23)
                .goalsLoser(15)
                .goalKicksWinner(59)
                .goalKicksLoser(37)
                .committedFaultsWinner(10)
                .committedFaultsLoser(10)
                .yellowCardsWinner(9)
                .yellowCardsLoser(8)
                .more(null)
                .build();

        BettingDataResponseDto responseDto = BettingDataResponseDto.builder()
                .data(gameStatisticsDto)
                .build();
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/odds")
    public ResponseEntity<BettingDataResponseDto<GameOddsDto>> findGameOdds() {
        List<GameOddsDto> oddsDtoList = new ArrayList<>();

        GameOddsDto gameOddsDto = GameOddsDto.builder()
                .bookmaker("BetFair")
                .odds(List.of(2.0, 1.0, 0.5))
                .build();
        oddsDtoList.add(gameOddsDto);

        GameOddsDto gameOddsDto2 = GameOddsDto.builder()
                .bookmaker("Bet365")
                .odds(List.of(0.8, 2.0, 3.5))
                .build();
        oddsDtoList.add(gameOddsDto2);

        GameOddsDto gameOddsDto3 = GameOddsDto.builder()
                .bookmaker("InfinityBet")
                .odds(List.of(5.0, 0.7, 0.5))
                .build();
        oddsDtoList.add(gameOddsDto3);

        GameOddsDto gameOddsDto4 = GameOddsDto.builder()
                .bookmaker("SportingBet")
                .odds(List.of(2.0, 1.0, 0.5))
                .build();
        oddsDtoList.add(gameOddsDto4);

        BettingDataResponseDto responseDto = BettingDataResponseDto.builder()
                .data(oddsDtoList)
                .build();
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/results")
    public ResponseEntity<BettingDataResponseDto<ResultRoundDto>> findResultsRound() {
        List<ResultRoundDto> resultRoundDtoList = new ArrayList<>();

        DetailResultDto detailResultDto = DetailResultDto.builder()
                .goalsWinner(20)
                .goalsConcededWinner(0)
                .cornersWinner(5)
                .yellowCardsWinner(2)
                .goalsLoser(0)
                .goalsConcededLoser(20)
                .cornersLoser(29)
                .yellowCardsLoser(20)
                .build();

        ResultRoundDto gameOddsDto = ResultRoundDto.builder()
                .league("Serie A")
                .winner("Santa Cruz")
                .goalsWinner(20)
                .flagWinner("http da bandeira")
                .loser("Sport")
                .goalsLoser(0)
                .flagLoser("Bandeira do lixo")
                .date("2023-08-23 12:23:09")
                .detail(detailResultDto)
                .build();
        resultRoundDtoList.add(gameOddsDto);

        BettingDataResponseDto responseDto = BettingDataResponseDto.builder()
                .data(resultRoundDtoList)
                .build();
        return ResponseEntity.ok(responseDto);
    }

//    @GetMapping("/tips")
//    public ResponseEntity<BettingDataResponseDto<BettingDataDto>> findTipsData() {
//        List<BettingDataDto> bettingDataDtoList = new ArrayList<>();
//
//        BettingDataDto bettingDataDto = BettingDataDto.builder()
//                .league("Serie A")
//                .winner("Atletico-MG")
//                .goalsWinner(3)
//                .flagWinner("https://media-1.api-sports.io/football/teams/1062.png")
//                .loser("Vasco DA Gama")
//                .goalsLoser(0)
//                .flagLoser("https://media-1.api-sports.io//football//teams//133.png")
//                .date("2023-08-22 21:12:34")
//                .bookmaker("Bet365")
//                .betPayment("1.50, 1.00, 0.5")
//                .build();
//        bettingDataDtoList.add(bettingDataDto);
//
//        BettingDataDto bettingDataDto2 = BettingDataDto.builder()
//                .league("Serie A")
//                .winner("Atletico-MG")
//                .goalsWinner(3)
//                .flagWinner("https://media-1.api-sports.io/football/teams/1062.png")
//                .loser("Vasco DA Gama")
//                .goalsLoser(0)
//                .flagLoser("https://media-1.api-sports.io//football//teams//133.png")
//                .date("2023-08-22 21:12:34")
//                .bookmaker("Bet365")
//                .betPayment("1.50, 1.00, 0.5")
//                .build();
//        bettingDataDtoList.add(bettingDataDto2);
//
//        BettingDataDto bettingDataDto3 = BettingDataDto.builder()
//                .league("Serie A")
//                .winner("Atletico-MG")
//                .goalsWinner(3)
//                .flagWinner("https://media-1.api-sports.io/football/teams/1062.png")
//                .loser("Vasco DA Gama")
//                .goalsLoser(0)
//                .flagLoser("https://media-1.api-sports.io//football//teams//133.png")
//                .date("2023-08-22 21:12:34")
//                .bookmaker("Bet365")
//                .betPayment("1.50, 1.00, 0.5")
//                .build();
//        bettingDataDtoList.add(bettingDataDto3);
//
//        BettingDataDto bettingDataDto4 = BettingDataDto.builder()
//                .league("Serie A")
//                .winner("Atletico-MG")
//                .goalsWinner(3)
//                .flagWinner("https://media-1.api-sports.io/football/teams/1062.png")
//                .loser("Vasco DA Gama")
//                .goalsLoser(0)
//                .flagLoser("https://media-1.api-sports.io//football//teams//133.png")
//                .date("2023-08-22 21:12:34")
//                .bookmaker("Bet365")
//                .betPayment("1.50, 1.00, 0.5")
//                .build();
//        bettingDataDtoList.add(bettingDataDto4);
//
//        BettingDataResponseDto responseDto = BettingDataResponseDto.builder()
//                .data(bettingDataDtoList)
//                .build();
//        return ResponseEntity.ok(responseDto);
//    }
}
