package com.palpites.pro.api.bettingdata.dto.response;

import com.palpites.pro.api.bettingdata.dto.BettingDataDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BettingDataResponseDto<T> {
    private T data;
}
