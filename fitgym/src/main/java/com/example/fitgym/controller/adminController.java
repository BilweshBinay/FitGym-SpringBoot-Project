package com.example.fitgym.controller;

import com.example.fitgym.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class adminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/sendotp")
    public String sendOtp(@RequestParam("adminEmail") String adminEmail, HttpServletRequest request) {
//        HttpSession: It is a temporary storage on the server used to remember a
//                      a user between multiple requests.
        HttpSession session = request.getSession();
        if (adminService.sendOtpToEmail(adminEmail)) {
            session.setAttribute("otpSent", true);
            session.setAttribute("email", adminEmail);
            request.setAttribute("message", "OTP sent successfully to your Email");
        } else {
            request.setAttribute("error", "Invalid Email or email not registered!");
        }
        return "admin/login";
    }

    @PostMapping("/verifyOtp")
    public String verifyOtp(@RequestParam("adminOtp") String otp, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        if (adminService.verifyOtp(email, otp)) {
            return "admin/dashboard";
        }
        request.setAttribute("error", "Invalid OTP!");
        return "admin/login";
    }
}
