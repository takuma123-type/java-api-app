package com.example.menta_api.usecase.userusecase.userinput;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserInput {
    private final String firstName;
    private final String lastName;

    @JsonCreator
    public CreateUserInput(
            @JsonProperty("firstName") String firstName, 
            @JsonProperty("lastName") String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }
}
