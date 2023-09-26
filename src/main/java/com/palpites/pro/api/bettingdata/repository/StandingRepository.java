package com.palpites.pro.api.bettingdata.repository;

import com.palpites.pro.api.bettingdata.entity.StandingEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandingRepository extends JpaRepository<StandingEntity, String> {

    List<StandingEntity> findByLeagueName(String nome);
    Optional<StandingEntity> findByLeagueNameAndTeamId(String nome, Integer teamId);
}
