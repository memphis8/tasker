package com.java.step.demo.controller;

import com.java.step.demo.entity.Reminder;
import com.java.step.demo.repo.ReminderRepo;
import com.java.step.demo.servise.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;


@Controller
@AllArgsConstructor
@RequestMapping("reminder")
public class AddReminderController {
    UserService userService;
    ReminderRepo reminderRepo;

    @GetMapping("add_reminder")
    public String getPageAddReminder(Model model){
        model.addAttribute("reminder",new Reminder());
        return "add_reminders";
    }

    @PostMapping("add_new_reminder")
    public String addNewReminder(@Valid Reminder reminder, Errors errors){
        if(errors.hasErrors()){
            return "add_reminders";
        }
        fillingOutDateAndUserInReminder(reminder);
        return "redirect:/reminder/reminders";
    }

    @GetMapping("change")
    public String getPageAddReminder(@RequestParam Long id, Model model){
        Reminder reminder = reminderRepo.findById(id).get();
        model.addAttribute("reminder",reminder);
        return "change_reminder";
    }

    @PostMapping("change")
    public String saveChangeReminder(@RequestParam Long id, @Valid Reminder reminder, Errors errors){
        if(errors.hasErrors()){
            return "change_reminder";
        }
        Reminder reminderFromDb = reminderRepo.findById(id).get();
        reminderFromDb.setDate(new Date().toString());
        reminderFromDb.setBody(reminder.getBody());
        reminderFromDb.setTag(reminder.getTag());
        reminderFromDb.setName(reminder.getName());
        reminderRepo.save(reminderFromDb);
        return "redirect:/reminder/reminders";
    }



    private void fillingOutDateAndUserInReminder(@Valid Reminder reminder) {
        reminder.setDate(new Date().toString());
        reminder.setUser(userService.getUser());
        reminderRepo.save(reminder);
    }

}
