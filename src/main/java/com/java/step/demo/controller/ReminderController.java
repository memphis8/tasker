package com.java.step.demo.controller;

import com.java.step.demo.entity.Reminder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("reminder")
public class ReminderController {

    @GetMapping("{userName}")
    public String getUserReminders(@PathVariable String userName, Model model){
        model.addAttribute("reminders",new ArrayList<Reminder>());
        return "reminder";
    }
}
