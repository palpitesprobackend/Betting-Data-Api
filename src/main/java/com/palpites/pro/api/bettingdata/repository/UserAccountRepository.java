package com.palpites.pro.api.bettingdata.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.palpites.pro.api.bettingdata.entity.UserEntity;

@Repository
public interface UserAccountRepository extends JpaRepository<UserEntity, String> {
    boolean existsByNomeAndEmail(String nome, String email);

    Optional<UserEntity> findByNomeAndEmail(String nome, String email);
}
