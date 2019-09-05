package com.java.step.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("reminder")
public class AddReminderController {

    @GetMapping("{userName}/add_reminder")
    public String addNewReminderToUser(@PathVariable String userName, Model model){
        return "add_reminder";
    }


}
