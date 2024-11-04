package com.example.menta_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseTestController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseTestController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/db-test")
    public String testDatabaseConnection() {
        try {
            String result = jdbcTemplate.queryForObject("SELECT NOW()", String.class);
            return "Database connection successful! Current date and time: " + result;
        } catch (Exception e) {
            return "Database connection failed: " + e.getMessage();
        }
    }
}
