package com.example.menta_api.domain.userdm;

import com.example.menta_api.domain.shared.CreatedAt;
import com.example.menta_api.support.err.ErrorFactory;

public class UserEntity {
    private final UserID id;
    private final String firstName;
    private final String lastName;
    private final CreatedAt createdAt;

    private static final int FIRST_NAME_LENGTH = 30;
    private static final int LAST_NAME_LENGTH = 30;

    private UserEntity(UserID id, String firstName, String lastName, CreatedAt createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
    }

    public static UserEntity newUser(UserID id, String firstName, String lastName, CreatedAt createdAt) {
        validateName(firstName, "first name", FIRST_NAME_LENGTH);
        validateName(lastName, "last name", LAST_NAME_LENGTH);
        return new UserEntity(id, firstName, lastName, createdAt);
    }

    public UserID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public CreatedAt getCreatedAt() {
        return createdAt;
    }

    private static void validateName(String name, String fieldName, int maxLength) {
        if (name == null || name.isBlank()) {
            throw ErrorFactory.badRequest(fieldName + " must not be empty");
        }
        if (name.length() > maxLength) {
            throw ErrorFactory.badRequest(fieldName + " must be less than " + maxLength + " characters");
        }
    }
}
