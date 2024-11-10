package com.example.menta_api.usecase.userusecase;

import com.example.menta_api.domain.userdm.UserEntity;
import com.example.menta_api.domain.userdm.UserFactory;
import com.example.menta_api.domain.userdm.UserRepository;
import com.example.menta_api.usecase.userusecase.userinput.CreateUserInput;
import com.example.menta_api.usecase.userusecase.useroutput.CreateUserOutput;
import java.util.concurrent.CompletableFuture;

public class CreateUserUsecase {

    private final UserRepository userRepository;

    public CreateUserUsecase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CompletableFuture<CreateUserOutput> exec(CreateUserInput input) {
        UserEntity user = UserFactory.genWhenCreate(input.getFirstName(), input.getLastName());
        return userRepository.store(user).thenApplyAsync(v -> new CreateUserOutput(
            user.getId().toString(),
            user.getFirstName(),
            user.getLastName(),
            user.getCreatedAt().getValue()
        ));
    }
}
