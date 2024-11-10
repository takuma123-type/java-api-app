package com.example.menta_api.domain.userdm;

import java.util.UUID;

public class UserID {
    private final String id;

    private UserID(String id) {
        this.id = id;
    }

    public static UserID newUserID() {
        return new UserID(UUID.randomUUID().toString());
    }

    @Override
    public String toString() {
        return id;
    }
}
