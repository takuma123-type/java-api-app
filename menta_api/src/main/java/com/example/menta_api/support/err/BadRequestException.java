
package com.example.menta_api.support.err;
import org.springframework.http.HttpStatus;

public class BadRequestException extends AppError {
    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message, new Throwable(message));
    }
}
