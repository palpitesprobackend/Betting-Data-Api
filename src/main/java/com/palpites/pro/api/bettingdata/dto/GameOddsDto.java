package com.palpites.pro.api.bettingdata.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GameOddsDto {
    private String bookmaker;
    private List<Double> odds;
}
