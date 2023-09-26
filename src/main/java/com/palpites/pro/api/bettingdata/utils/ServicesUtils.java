package com.palpites.pro.api.bettingdata.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ServicesUtils {

    public static String getLocalDateTimeNow(String format) {
        return LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).format(DateTimeFormatter.ofPattern(format));
    }
}
