package com.example.menta_api.infra.router;

import com.example.menta_api.interfaces.controller.UserController;
import com.example.menta_api.usecase.userusecase.userinput.CreateUserInput;
import com.example.menta_api.support.err.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Configuration
@RestController
@RequestMapping("/api")
public class UserRouter {

    private final UserController userController;

    @Autowired
    public UserRouter(UserController userController) {
        this.userController = userController;
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody CreateUserInput input) {
        try {
            userController.createUser(input);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the user.");
        }
    }
}
