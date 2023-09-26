package com.palpites.pro.api.bettingdata.service;

import java.util.List;
import com.palpites.pro.api.bettingdata.client.ApiFootBallClient;
import com.palpites.pro.api.bettingdata.dto.bets.BettingDataDto;
import com.palpites.pro.api.bettingdata.dto.bets.StandingsDto;
import com.palpites.pro.api.bettingdata.entity.StandingEntity;
import com.palpites.pro.api.bettingdata.entity.TipsEntity;
import com.palpites.pro.api.bettingdata.repository.StandingRepository;
import com.palpites.pro.api.bettingdata.repository.TipsRepository;
import com.palpites.pro.api.bettingdata.utils.ServicesUtils;
import lombok.RequiredArgsConstructor;
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

    private final ApiFootBallClient client;
    private final TipsRepository tipsRepository;
    private final StandingRepository standingRepository;


    public ApiFootBallClient findStandingsByLeague(String leagueName) {
        return client;
    }

    public void saveTips() {
        List<BettingDataDto> bettingTipsList = client.findBettingTips();
        bettingTipsList.forEach(bettingDataDto ->  tipsRepository.save(parseTipsDtoToEntity(bettingDataDto)));
    }

    public void saveStanding() {
        List<StandingsDto> standingsList = client.findStandings();
        standingsList.forEach(standingsDto ->  standingRepository.save(parseStandingsDtoToEntity(standingsDto)));
    }

    private TipsEntity parseTipsDtoToEntity(BettingDataDto dataDto) {
        return TipsEntity.builder()
                .advice(dataDto.getAdvice())
                .winner(dataDto.getWinner())
                .flagWinner(dataDto.getFlagWinner())
                .loser(dataDto.getLoser())
                .flagLoser(dataDto.getFlagLoser())
                .date(dataDto.getDate())
                .bookmaker(dataDto.getBookmaker())
                //TODO:OBSERVAR este ponto
                .betPayment(dataDto.getBetPayment())
                .createdAt(ServicesUtils.getLocalDateTimeNow("yyyy-MM-dd HH:mm:ss"))
                .updatedAt(null)
                .build();
    }

    private StandingEntity parseStandingsDtoToEntity(StandingsDto dto) {
    return StandingEntity.builder()
        .leagueId(dto.getLeagueId())
        .leagueName(dto.getLeagueName())
        .leagueLogo(dto.getLeagueLogo())
        .teamId(dto.getTeamId())
        .ranking(dto.getRanking())
        .nameTeam(dto.getNameTeam())
        .flag(dto.getFlag())
        .points(dto.getPoints())
        .playedTot(dto.getPlayedTot())
        .winTot(dto.getWinTot())
        .drawTot(dto.getDrawTot())
        .loseTot(dto.getLoseTot())
        .playedHome(dto.getPlayedHome())
        .winHome(dto.getWinTot())
        .drawHome(dto.getDrawHome())
        .loseHome(dto.getLoseHome())
        .playedAway(dto.getPlayedAway())
        .winAway(dto.getWinAway())
        .drawAway(dto.getDrawAway())
        .loseAway(dto.getLoseAway())
        .createdAt(ServicesUtils.getLocalDateTimeNow("yyyy-MM-dd HH:mm:ss"))
        .updatedAt(null)
        .build();
    }

}
