package com.palpites.pro.api.bettingdata.repository;

import com.palpites.pro.api.bettingdata.entity.TipsEntity;
import com.palpites.pro.api.bettingdata.entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipsRepository extends JpaRepository<TipsEntity, String> {
    boolean existsByNomeAndEmail(String nome, String email);

    List<TipsEntity> findByLeagueNameAndDate(String leagueName, String date);
}
