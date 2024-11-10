package com.example.menta_api.interfaces.presenter;

import com.example.menta_api.usecase.userusecase.useroutput.CreateUserOutput;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class UserPresenterImpl implements UserPresenter {

    private static final Logger logger = LoggerFactory.getLogger(UserPresenterImpl.class);

    @Override
    public void create(CreateUserOutput out) {
        logger.info("User created: ID={}, FirstName={}, LastName={}", out.getId(), out.getFirstName(), out.getLastName());
    }
}
