package com.palpites.pro.api.bettingdata.repository;

import com.palpites.pro.api.bettingdata.entity.TipsEntity;
import com.palpites.pro.api.bettingdata.entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TipsRepository extends JpaRepository<TipsEntity, String> {
    Boolean existsByLeagueId(Integer leagueId);
    List<TipsEntity> findByLeagueNameAndDate(String leagueName, String date);

    @Query("DELETE FROM TipsEntity t WHERE t.leagueId IN :leagueId")
    void deleteAllById(Integer leagueId);
}
