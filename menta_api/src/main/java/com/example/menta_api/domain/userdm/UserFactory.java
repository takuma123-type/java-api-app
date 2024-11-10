package com.example.menta_api.domain.userdm;

import com.example.menta_api.domain.shared.CreatedAt;

public class UserFactory {
    public static UserEntity genWhenCreate(String firstName, String lastName) {
        return UserEntity.newUser(UserID.newUserID(), firstName, lastName, CreatedAt.newCreatedAt());
    }
}
