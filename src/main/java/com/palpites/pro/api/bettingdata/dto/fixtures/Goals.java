package com.palpites.pro.api.bettingdata.dto.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class Goals{
    private Object home;
    private Object away;
}
