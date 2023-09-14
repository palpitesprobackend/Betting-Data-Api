package com.palpites.pro.api.bettingdata.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BettingDataResponseDto<T> {
    private T data;
}
