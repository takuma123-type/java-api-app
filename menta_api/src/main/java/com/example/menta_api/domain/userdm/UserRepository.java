package com.example.menta_api.domain.userdm;

import java.util.concurrent.CompletableFuture;

public interface UserRepository {
    CompletableFuture<Void> store(UserEntity user);
}
