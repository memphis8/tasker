package com.java.step.demo.controller;

import com.java.step.demo.entity.Reminder;
import com.java.step.demo.repo.ReminderRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("reminder")
public class AddReminderController {
    ReminderRepo reminderRepo;

    @GetMapping("add_reminder")
    public String getPageAddReminder(Model model){
        model.addAttribute("reminder",new Reminder());
        return "add_reminders";
    }

    @PostMapping("add_new_reminder")
    public String addNewReminder(@ModelAttribute @Valid Reminder reminder, Errors errors){
        if(errors.hasErrors()){
            return "add_reminders";
        }
        reminderRepo.save(reminder);
        return "redirect:/reminder/reminders";
    }

}
