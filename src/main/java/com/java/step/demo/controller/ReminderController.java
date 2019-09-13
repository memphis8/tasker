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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("reminder")
@AllArgsConstructor
public class ReminderController {

    private UserRepo userRepo;
    private UserService userService;
    private ReminderRepo reminderRepo;

    @GetMapping("reminders")
    public String getUserReminders(@RequestParam(name = "searchName", required = false, defaultValue = "all") String searchName,
                                   @RequestParam(name = "param", required = false, defaultValue = "0") int param,
                                   Model model){
        List<Reminder> searchReminder;
        if (searchName.equals("all")&&param==0){
            searchReminder = reminderRepo.findAllByUser_Username(userService.getUser().getUsername());
            model.addAttribute("reminders", searchReminder);
        }else if (param==1){
            searchReminder = reminderRepo.findAllByUser_Username(userService.getUser().getUsername());
            searchReminder = searchReminder.stream()
                    .filter(reminder -> reminder.getName().equals(searchName))
                    .collect(Collectors.toList());
            model.addAttribute("reminders", searchReminder);
        }else if (param==2){
            searchReminder = reminderRepo.findAllByUser_Username(userService.getUser().getUsername());
            searchReminder = searchReminder.stream()
                    .filter(reminder -> reminder.getTag().equals(searchName))
                    .collect(Collectors.toList());
            model.addAttribute("reminders", searchReminder);
        }
        return"reminders";
    }
}
