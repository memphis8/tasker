package com.java.step.demo.controller;

import com.java.step.demo.entity.Reminder;
import com.java.step.demo.repo.ReminderRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("reminder")
public class AddReminderController {
    ReminderRepo reminderRepo;

    @GetMapping("add_reminder")
    public String getPageAddReminder(){
        return "add_reminders";
    }

    @PostMapping("add_new_reminder")
    public String addNewReminder(@ModelAttribute Reminder reminder){
        reminderRepo.save(reminder);
        return "redirect:/reminder/reminders";
    }

}
