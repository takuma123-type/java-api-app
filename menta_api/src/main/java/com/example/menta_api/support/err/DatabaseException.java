package com.example.menta_api.support.err;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String operation, Throwable cause) {
        super("Database operation '" + operation + "' failed: " + cause.getMessage(), cause);
    }
}
