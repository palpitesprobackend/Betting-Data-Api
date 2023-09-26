package com.palpites.pro.api.bettingdata.service;

import com.palpites.pro.api.bettingdata.dto.bets.BettingDataDto;
import com.palpites.pro.api.bettingdata.dto.bets.StandingsDto;
import com.palpites.pro.api.bettingdata.entity.StandingEntity;
import com.palpites.pro.api.bettingdata.entity.TipsEntity;
import com.palpites.pro.api.bettingdata.exceptions.ExceptionMessages;
import com.palpites.pro.api.bettingdata.repository.StandingRepository;
import com.palpites.pro.api.bettingdata.repository.TipsRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindDataService {

    private final TipsRepository tipsRepository;
    private final StandingRepository standingRepository;

    public List<BettingDataDto> findBettingTips(String nameLeague, String date) {
        //TODO: VERIFICAR SE NÃO GERA NULLPOINTER sem o new ArrayList
//        List<BettingDataDto> bettingDataDtoList = new ArrayList<>();
        List<BettingDataDto> bettingDataDtoList;
        List<TipsEntity> entityList = tipsRepository.findByLeagueNameAndDate(nameLeague, date);

        if (Objects.nonNull(entityList) && !entityList.isEmpty()) {
            bettingDataDtoList = entityList.stream()
                    .map(this::parseEntityToDto)
                    .collect(Collectors.toList());
        } else
          throw new ExceptionMessages(
              HttpStatus.BAD_REQUEST, "Nenhum palpite foi encontrado para data e liga informados");

        return bettingDataDtoList;
    }

    public List<StandingsDto> findStanding(String nameLeague) {
        List<StandingsDto> standingsDtoList;
        List<StandingEntity> entityList = standingRepository.findByLeagueName(nameLeague);

        if (Objects.nonNull(entityList) && !entityList.isEmpty()) {
            entityList.sort(Comparator.comparingInt(StandingEntity::getRanking));
            standingsDtoList = entityList.stream()
                    .map(this::parseEntityToStandingsDto)
                    .collect(Collectors.toList());
        } else
            throw new ExceptionMessages(
                    HttpStatus.BAD_REQUEST, "Nenhuma classificacao foi encontrada para a liga informada");

        return standingsDtoList;
    }

    public List<StandingsDto> findH2H(String nameLeague, Integer teamIdWinner, Integer teamIdLoser) {
        List<StandingsDto> standingsDtoList = new ArrayList<>();
        Optional<StandingEntity> entityWinner = standingRepository.findByLeagueNameAndTeamId(nameLeague, teamIdWinner);
        Optional<StandingEntity> entityLoser = standingRepository.findByLeagueNameAndTeamId(nameLeague, teamIdLoser);

        if (entityWinner.isPresent() && entityLoser.isPresent()) {
            var winnerClassification = parseEntityToStandingsDto(entityWinner.get());
            standingsDtoList.add(winnerClassification);
            var loserClassification = parseEntityToStandingsDto(entityLoser.get());
            standingsDtoList.add(loserClassification);
        } else
            throw new ExceptionMessages(
                    HttpStatus.BAD_REQUEST, "Informacoes de classificacao nao encontradas para os dados informados");

        return standingsDtoList;
    }

    private BettingDataDto parseEntityToDto(TipsEntity entity) {
    return BettingDataDto.builder()
        .nameLeague(entity.getLeagueName())
        .advice(entity.getAdvice())
        .winner(entity.getWinner())
        .flagWinner(entity.getFlagWinner())
        .loser(entity.getLoser())
        .flagLoser(entity.getFlagLoser())
        .date(entity.getDate())
        .bookmaker(entity.getBookmaker())
        // TODO:OBSERVAR este ponto
        .betPayment(entity.getBetPayment())
        .build();
    }

    private StandingsDto parseEntityToStandingsDto(StandingEntity entity) {
    return StandingsDto.builder()
        .leagueId(entity.getLeagueId())
        .leagueName(entity.getLeagueName())
        .leagueLogo(entity.getLeagueLogo())
        .teamId(entity.getTeamId())
        .ranking(entity.getRanking())
        .nameTeam(entity.getNameTeam())
        .flag(entity.getFlag())
        .points(entity.getPoints())
        .playedTot(entity.getPlayedTot())
        .winTot(entity.getWinTot())
        .drawTot(entity.getDrawTot())
        .loseTot(entity.getLoseTot())
        .playedHome(entity.getPlayedHome())
        .winHome(entity.getWinTot())
        .drawHome(entity.getDrawHome())
        .loseHome(entity.getLoseHome())
        .playedAway(entity.getPlayedAway())
        .winAway(entity.getWinAway())
        .drawAway(entity.getDrawAway())
        .loseAway(entity.getLoseAway())
        .round(entity.getRound())
        .build();
    }
}
