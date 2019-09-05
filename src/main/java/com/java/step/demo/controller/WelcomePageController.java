package com.java.step.demo.controller;

import com.java.step.demo.entity.User;
import com.java.step.demo.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class WelcomePageController {

    private UserRepo userRepo;

    @GetMapping
    public String seeWPage(){
        return "welcome_page";
    }

    @GetMapping("/login")
    public String getlogin(){
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("message","");
        return "registration";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("mvc-dispatcher") User user, ModelMap model){
        return "we";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("mvc-dispatcher") User user, Model model){
        userRepo.save(user);
        model.addAttribute("userForm", user);
        return "redirect:/login";
    }
}
