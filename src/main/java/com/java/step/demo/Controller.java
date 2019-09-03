package com.java.step.demo;

import org.springframework.web.bind.annotation.GetMapping;

public class Controller {

    @GetMapping("/greeting")
    public String greeting()
}
