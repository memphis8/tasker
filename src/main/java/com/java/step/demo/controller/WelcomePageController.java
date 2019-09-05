package com.java.step.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomePageController {

    @GetMapping
    public String seeWPage(){
        return "welcome_page";
    }
    //hi there!
}
