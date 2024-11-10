package com.example.menta_api.support.err;

import org.springframework.http.HttpStatus;

public class NotFoundException extends AppError {
    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message, new Throwable(message));
    }
}
