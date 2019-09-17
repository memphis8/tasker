package com.java.step.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("search")
public class NavBarController {

    @GetMapping("nav_bar")
    public String getNavBar(){
        return "nav_bar";
    }

    @PostMapping("nav_bar_search")
    public String searchByName(@RequestParam String searchName) {
        return "redirect:/reminder/reminders?searchName="+searchName+"&"+"param=1";
    }

}
