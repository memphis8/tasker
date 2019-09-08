package com.java.step.demo.controller;

import com.java.step.demo.entity.User;
import com.java.step.demo.repo.ReminderRepo;
import com.java.step.demo.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Collections;

@Controller
@RequestMapping("/")
public class MainController {
    private UserRepo userRepo;
    private ReminderRepo reminderRepo;

    @GetMapping("sign_in")
    public String getLogin(){
        return "login";
    }

    @GetMapping("registration")
    public String getRegistration(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }

//    @PostMapping("registration")
//    public String addNewUser(@Valid User user, Errors errors){
//        if(errors.hasFieldErrors()){
//            return "registration";
//        }
//        userRepo.save(user);
//        return "redirect:/sign_in";
//    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute @Valid User user, Model model, Errors errors) {
        User userFromDb = userRepo.findByLogin(user.getLogin());

        if(errors.hasFieldErrors()){
            model.addAttribute("")
            return "registration";
        }

        if (userFromDb != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}
