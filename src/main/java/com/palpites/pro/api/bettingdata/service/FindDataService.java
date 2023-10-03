package com.palpites.pro.api.bettingdata.service;

import com.palpites.pro.api.bettingdata.dto.bets.BettingDataRespDto;
import com.palpites.pro.api.bettingdata.dto.bets.StandingResponseDto;
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

    public List<BettingDataRespDto> findBettingTips(String nameLeague, String date) {
        //TODO: VERIFICAR SE NÃO GERA NULLPOINTER sem o new ArrayList
//        List<BettingDataDto> bettingDataDtoList = new ArrayList<>();
        List<BettingDataRespDto> bettingDataRespDtoList;
        List<TipsEntity> entityList = tipsRepository.findByLeagueNameAndDate(nameLeague, date);

        if (Objects.nonNull(entityList) && !entityList.isEmpty()) {
            bettingDataRespDtoList = entityList.stream()
                    .map(this::parseEntityToDto)
                    .collect(Collectors.toList());
        } else
          throw new ExceptionMessages(
              HttpStatus.BAD_REQUEST, "Nenhum palpite foi encontrado para data e liga informados");

        return bettingDataRespDtoList;
    }

    public List<StandingResponseDto> findStanding(String nameLeague) {
        List<StandingResponseDto> standingResponseDtoList;
        List<StandingEntity> entityList = standingRepository.findByLeagueName(nameLeague);

        if (Objects.nonNull(entityList) && !entityList.isEmpty()) {
            entityList.sort(Comparator.comparingInt(StandingEntity::getRanking));
            standingResponseDtoList = entityList.stream()
                    .map(this::parseEntityToStandingsDto)
                    .collect(Collectors.toList());
        } else
            throw new ExceptionMessages(
                    HttpStatus.BAD_REQUEST, "Nenhuma classificacao foi encontrada para a liga informada");

        return standingResponseDtoList;
    }

    public List<StandingResponseDto> findH2H(String nameLeague, Integer teamIdWinner, Integer teamIdLoser) {
        List<StandingResponseDto> standingResponseDtos = new ArrayList<>();
        Optional<StandingEntity> entityWinner = standingRepository.findByLeagueNameAndTeamId(nameLeague, teamIdWinner);
        Optional<StandingEntity> entityLoser = standingRepository.findByLeagueNameAndTeamId(nameLeague, teamIdLoser);

        if (entityWinner.isPresent() && entityLoser.isPresent()) {
            var winnerClassification = parseEntityToStandingsDto(entityWinner.get());
            standingResponseDtos.add(winnerClassification);
            var loserClassification = parseEntityToStandingsDto(entityLoser.get());
            standingResponseDtos.add(loserClassification);
        } else
            throw new ExceptionMessages(
                    HttpStatus.BAD_REQUEST, "Informacoes de classificacao nao encontradas para os dados informados");

        return standingResponseDtos;
    }

    private BettingDataRespDto parseEntityToDto(TipsEntity entity) {
        BettingDataRespDto dto = new BettingDataRespDto();
        dto.setNameLeague(entity.getLeagueName());
        dto.setAdvice(entity.getAdvice());
        dto.setWinner(entity.getWinner());
        dto.setFlagWinner(entity.getFlagWinner());
        dto.setLoser(entity.getLoser());
        dto.setFlagLoser(entity.getFlagLoser());
        dto.setDate(entity.getDate());
        dto.setBookmaker(entity.getBookmaker());
        return dto;
    }

    private StandingResponseDto parseEntityToStandingsDto(StandingEntity entity) {
        StandingResponseDto standingResponseDto = new StandingResponseDto();
        standingResponseDto.setLeagueId(entity.getLeagueId());
        standingResponseDto.setLeagueName(entity.getLeagueName());
        standingResponseDto.setLeagueLogo(entity.getLeagueLogo());
        standingResponseDto.setTeamId(entity.getTeamId());
        standingResponseDto.setRanking(entity.getRanking());
        standingResponseDto.setNameTeam(entity.getNameTeam());
        standingResponseDto.setFlag(entity.getFlag());
        standingResponseDto.setPoints(entity.getPoints());
        standingResponseDto.setPlayedTot(entity.getPlayedTot());
        standingResponseDto.setWinTot(entity.getWinTot());
        standingResponseDto.setDrawTot(entity.getDrawTot());
        standingResponseDto.setLoseTot(entity.getLoseTot());
        standingResponseDto.setPlayedHome(entity.getPlayedHome());
        standingResponseDto.setWinHome(entity.getWinTot());
        standingResponseDto.setDrawHome(entity.getDrawHome());
        standingResponseDto.setLoseHome(entity.getLoseHome());
        standingResponseDto.setPlayedAway(entity.getPlayedAway());
        standingResponseDto.setWinAway(entity.getWinAway());
        standingResponseDto.setDrawAway(entity.getDrawAway());
        standingResponseDto.setLoseAway(entity.getLoseAway());

        return standingResponseDto;
    }
}
