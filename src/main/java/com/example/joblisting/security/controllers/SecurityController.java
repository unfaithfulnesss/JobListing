package com.example.joblisting.security.controllers;

import com.example.joblisting.entities.JobListing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/")
    public String home(){
        return "redirect:/JobListingsList";
    }
    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "/AccessDenied";
    }
    @GetMapping("/login")
    public String login(){
        return "/Login";
    }
}
