package com.java.step.demo.controller;

import com.java.step.demo.entity.Reminder;
import com.java.step.demo.repo.ReminderRepo;
import com.java.step.demo.repo.UserRepo;
import com.java.step.demo.servise.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("reminder")
@AllArgsConstructor
public class ReminderController {

    private UserRepo userRepo;
    private UserService userService;
    private ReminderRepo reminderRepo;

    @GetMapping("reminders")
    public String getUserReminders(Model model){
        List<Reminder> userReminder = reminderRepo.findAllByUser_Username(userService.getUser().getUsername());
        model.addAttribute("reminders",userReminder);
        return"reminders";
    }
}
