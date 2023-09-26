package com.palpites.pro.api.bettingdata.entity;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_STANDING")
public class StandingEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private Integer leagueId;
    private String leagueName;
    private String leagueLogo;
    private Integer teamId;
    private Integer ranking;
    private String nameTeam;
    private String flag;
    private Integer points;
    private Integer playedTot;
    private Integer winTot;
    private Integer drawTot;
    private Integer loseTot;
    private Integer playedHome;
    private Integer winHome;
    private Integer drawHome;
    private Integer loseHome;
    private Integer playedAway;
    private Integer winAway;
    private Integer drawAway;
    private Integer loseAway;
    private Integer round;

    private String createdAt;
    private String updatedAt;
}