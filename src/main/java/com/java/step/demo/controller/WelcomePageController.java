package com.java.step.demo.controller;

import com.java.step.demo.entity.User;
import com.java.step.demo.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class WelcomePageController {
    private UserRepo userRepo;

    @GetMapping("sign_in")
    public String getLogin(){
        return "login";
    }

    @GetMapping("registration")
    public String getRegistration(){
        return "registration";
    }

    @GetMapping
    public String getWelcomePage(){
        return "welcome_page";
    }

    @PostMapping("add_new_user")
    public String addNewUser(@ModelAttribute User user, Model model){
        userRepo.save(user);
        model.addAttribute("user",user);
        return "redirect:/sign_in";
    }





}
