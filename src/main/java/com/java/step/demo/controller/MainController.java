package com.java.step.demo.controller;

import com.java.step.demo.entity.Role;
import com.java.step.demo.entity.User;
import com.java.step.demo.repo.ReminderRepo;
import com.java.step.demo.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Collections;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class MainController {
    private UserRepo userRepo;
    private ReminderRepo reminderRepo;

    @GetMapping("registration")
    public String getRegistration(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }

    @PostMapping("registration")
    public String addNewUser(@Valid User user, Errors errors, Model model){

        if(errors.hasFieldErrors()){
            return "registration";
        }

        if (userRepo.findByUsername(user.getUsername()) != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        userRepo.save(user);
        return "redirect:/login";
    }

}
