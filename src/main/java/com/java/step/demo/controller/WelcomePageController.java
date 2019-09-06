package com.java.step.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class WelcomePageController {

    @GetMapping
    public String getWelcomePage(){
        return "welcome_page";
    }







}
