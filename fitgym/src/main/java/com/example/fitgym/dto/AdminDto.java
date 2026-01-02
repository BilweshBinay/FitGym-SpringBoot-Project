package com.example.fitgym.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class AdminDto {
    private Integer id;
    private String adminName;
    private String adminEmail;
    private String adminOtp;
}
