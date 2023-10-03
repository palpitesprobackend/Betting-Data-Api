package com.palpites.pro.api.bettingdata.service;

import java.util.ArrayList;
import java.util.List;
import com.palpites.pro.api.bettingdata.client.ApiFootBallClient;
import com.palpites.pro.api.bettingdata.dto.bets.BettingDataDto;
import com.palpites.pro.api.bettingdata.dto.bets.StandingDto;
import com.palpites.pro.api.bettingdata.dto.bets.StandingsDataDto;
import com.palpites.pro.api.bettingdata.dto.bets.TipsDataDto;
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

    private final ApiFootBallClient client;
    private final TipsRepository tipsRepository;
    private final StandingRepository standingRepository;

    public void saveTips() {
        List<BettingDataDto> bettingTipsList = client.findBettingTips();
        if (!bettingTipsList.isEmpty()) {
            for (BettingDataDto dto : bettingTipsList) {
                if (dto.getLeagueId() != null) {
                    if (Boolean.TRUE.equals(tipsRepository.existsByLeagueId(dto.getLeagueId()))) {
                        tipsRepository.deleteAllById(dto.getLeagueId());
                        tipsRepository.saveAll(parseTipsDtoToEntity(dto.getTips(), dto.getLeagueId(), dto.getLeagueName()));
                    } else {
                        tipsRepository.saveAll(parseTipsDtoToEntity(dto.getTips(), dto.getLeagueId(), dto.getLeagueName()));
                    }
                }
            }
        }
    }

    public void saveStanding() {
        List<StandingsDataDto> standingsDataList = client.findStandings();
        if (!standingsDataList.isEmpty()) {
            for (StandingsDataDto dto : standingsDataList) {
                if (dto.getLeagueId() != null) {
                    if (Boolean.TRUE.equals(standingRepository.existsByLeagueId(dto.getLeagueId()))) {
                        standingRepository.deleteAllById(dto.getLeagueId());
                        standingRepository.saveAll(parseStandingsDtoToEntity(dto.getDataStanding(), dto));
                    } else {
                        standingRepository.saveAll(parseStandingsDtoToEntity(dto.getDataStanding(), dto));
                    }
                }
            }
        }
    }

    private List<TipsEntity> parseTipsDtoToEntity(List<TipsDataDto> dataDto, Integer leagueId, String leagueName) {
        List<TipsEntity> entityList = new ArrayList<>();
        for (TipsDataDto dto : dataDto) {
            TipsEntity entity = TipsEntity.builder()
                    .leagueId(leagueId)
                    .leagueName(leagueName)
                    .advice(dto.getAdvice())
                    .winner(dto.getWinner())
                    .flagWinner(dto.getFlagWinner())
                    .loser(dto.getLoser())
                    .flagLoser(dto.getFlagLoser())
                    .date(dto.getDate())
                    .bookmaker(dto.getBookmaker())
                    //TODO:OBSERVAR este ponto
                    .betPayment(dto.getBetPayment())
                    .createdAt(ServicesUtils.getLocalDateTimeNow("yyyy-MM-dd HH:mm:ss"))
                    .updatedAt(null)
                    .build();
            entityList.add(entity);
        }
         return entityList;
    }

    private List<StandingEntity> parseStandingsDtoToEntity(List<StandingDto> standingDtos, StandingsDataDto standingsDataDto) {
        List<StandingEntity> entityList = new ArrayList<>();
        for (StandingDto dto: standingDtos) {
            entityList.add(
                    StandingEntity.builder()
                    .leagueId(standingsDataDto.getLeagueId())
                    .leagueName(standingsDataDto.getLeagueName())
                    .leagueLogo(standingsDataDto.getLeagueLogo())
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
                    .build());
        }

    return entityList;
    }

}
