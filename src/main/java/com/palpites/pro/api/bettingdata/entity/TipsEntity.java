package com.palpites.pro.api.bettingdata.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_TIPS")
public class TipsEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private Integer leagueId;
    private String leagueName;
    private String advice;
    private String winner;
    private String flagWinner;
    private String loser;
    private String flagLoser;
    private String date;
    private String bookmaker;
    private List<Double> betPayment;

    private String createdAt;
    private String updatedAt;
}