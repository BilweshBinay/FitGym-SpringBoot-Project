package com.example.fitgym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FitGymController {

    @GetMapping("/fitgym")
    public String fitGymIndex() {
        return "index";
    }

    @GetMapping("/admin/login")
    public String adminLogin() {
        return "admin/login";
    }

    @GetMapping("/user/login")
    public String userLogin() {
        return "user/login";
    }
}
