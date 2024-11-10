package com.example.menta_api.support.err;

import org.springframework.http.HttpStatus;

public class InternalErrorException extends AppError {
    public InternalErrorException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message, new Throwable(message));
    }
}
