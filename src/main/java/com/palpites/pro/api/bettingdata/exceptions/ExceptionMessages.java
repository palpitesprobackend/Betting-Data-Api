package com.palpites.pro.api.bettingdata.exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionMessages extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;
    private final String message;
    private final Throwable throwable;

    public ExceptionMessages(final HttpStatus httpStatus, final String message) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.throwable = null;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
