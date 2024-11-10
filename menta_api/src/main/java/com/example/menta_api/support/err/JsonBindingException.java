package com.example.menta_api.support.err;

public class JsonBindingException extends RuntimeException {
    public JsonBindingException(String detail) {
        super("Failed to bind JSON: " + detail);
    }
}
