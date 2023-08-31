package com.palpites.pro.api.bettingdata.dto.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@JsonIgnoreProperties
public class FixtureResponseDto {
    private String get;
    private Parameters parameters;
    private ArrayList<Object> errors;
    private int results;
    private Paging paging;
    @JsonProperty("response")
    private ArrayList<ResponseDto> responseDto;
}