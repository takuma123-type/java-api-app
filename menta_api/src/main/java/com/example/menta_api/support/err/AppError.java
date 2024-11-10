package com.example.menta_api.support.err;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class AppError extends ResponseStatusException {
    private final String message;
    private final Throwable trace;

    public AppError(HttpStatus status, String message, Throwable trace) {
        super(status, message, trace);
        this.message = message;
        this.trace = trace;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Throwable getTrace() {
        return trace;
    }
}
