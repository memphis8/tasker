package com.java.step.demo.controller;

import com.java.step.demo.entity.Reminder;
import com.java.step.demo.repo.ReminderRepo;
import com.java.step.demo.servise.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("search")
public class NavBarController {

    private ReminderRepo reminderRepo;
    private UserService userService;

    @GetMapping("nav_bar")
    public String getNavBar(Model model){
        return "nav_bar";
    }

    @PostMapping("nav_bar_search")
    public String searchByName(@RequestParam String searchName, Model model) {
        List<Reminder> searchReminder;
        if (searchName.equals("")||searchName.equals(" ")||searchName.equals("All")||searchName.equals("all")){
            searchReminder = reminderRepo.findAllByUser_Username(userService.getUser().getUsername());
            model.addAttribute("reminders", searchReminder);
        }else{
            searchReminder = reminderRepo.findAllByUser_Username(userService.getUser().getUsername());
            searchReminder = searchReminder.stream()
                    .filter(reminder -> reminder.getName().equals(searchName))
                    .collect(Collectors.toList());
            model.addAttribute("reminders", searchReminder);
        }
        return "redirect:/reminder/reminders";
    }

}
