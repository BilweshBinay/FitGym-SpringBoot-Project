package com.example.fitgym.service;

public interface AdminService {

    boolean sendOtpToEmail(String adminEmail);
    boolean verifyOtp(String email, String otp);
}
