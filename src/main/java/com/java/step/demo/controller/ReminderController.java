package com.java.step.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("reminder")
public class ReminderController {

    @GetMapping("reminders")
    public String getUserReminders(){
        return"reminders";
    }



}
