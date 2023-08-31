package com.palpites.pro.api.bettingdata.dto.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class Away{
    private int id;
    private String name;
    private String logo;
    private Object winner;
}
