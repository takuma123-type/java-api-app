package com.example.menta_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MentaApiController {
    
    @GetMapping("/api")
    private String display(){
        return "/index.html";
    }
}
