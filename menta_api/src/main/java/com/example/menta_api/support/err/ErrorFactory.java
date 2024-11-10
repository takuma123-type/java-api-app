package com.example.menta_api.support.err;

public class ErrorFactory {
    public static BadRequestException badRequest(String message) {
        return new BadRequestException(message);
    }

    public static InternalErrorException internalError(String message) {
        return new InternalErrorException(message);
    }

    public static NotFoundException notFound(String message) {
        return new NotFoundException(message);
    }
}
