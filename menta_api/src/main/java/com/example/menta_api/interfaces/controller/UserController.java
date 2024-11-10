// src/main/java/com/example/menta_api/interfaces/controller/UserController.java

package com.example.menta_api.interfaces.controller;

import com.example.menta_api.domain.userdm.UserRepository;
import com.example.menta_api.interfaces.presenter.UserPresenter;
import com.example.menta_api.support.err.BadRequestException;
import com.example.menta_api.usecase.userusecase.CreateUserUsecase;
import com.example.menta_api.usecase.userusecase.userinput.CreateUserInput;
import com.example.menta_api.usecase.userusecase.useroutput.CreateUserOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.concurrent.ExecutionException;

@Controller
public class UserController {

    private final UserPresenter userPresenter;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserPresenter userPresenter, UserRepository userRepository) {
        this.userPresenter = userPresenter;
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> createUser(CreateUserInput createUserInput) {
        try {
            // CompletableFutureから結果を取得
            CreateUserUsecase useCase = new CreateUserUsecase(userRepository);
            CreateUserOutput output = useCase.exec(createUserInput).get();  // 非同期結果を取得

            // UserPresenterで作成結果を処理
            userPresenter.create(output);
            return ResponseEntity.status(HttpStatus.CREATED).body(output);
        } catch (ExecutionException | InterruptedException e) {
            Thread.currentThread().interrupt();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the user.");
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
