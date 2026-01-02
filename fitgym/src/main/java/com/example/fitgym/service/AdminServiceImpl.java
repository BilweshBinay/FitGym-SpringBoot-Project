package com.example.fitgym.service;

import com.example.fitgym.repository.AdminRepository;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Transactional
    @Override
    public boolean sendOtpToEmail(String adminEmail) {
        return adminRepository.findByAdminEmail(adminEmail)
                .map(admin -> {
                    String otp = generateOtp();
                    adminRepository.updateAdminOtp(adminEmail, otp);
                    return sendEmail(adminEmail, otp);
                })
                .orElse(false);
    }

    @Override
    public boolean verifyOtp(String adminEmail, String adminOtp) {

        return adminRepository.findByAdminEmail(adminEmail)
                .filter(admin -> adminOtp != null)
                .map(admin -> adminOtp.equals(admin.getAdminOtp()))
                .orElse(false);
    }

    private String generateOtp() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(100000,1000000));
    }

    private boolean sendEmail(String email, String otp) {
        final String from = "bilweshking25@gmail.com";
        final String password = "vwzi ztwx utli nqyp";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Your OTP for Admin Login");
            message.setText("Your OTP is: " + otp);

            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
