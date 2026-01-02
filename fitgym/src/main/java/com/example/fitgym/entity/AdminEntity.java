package com.example.fitgym.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "admin_table")

public class AdminEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "admin_name")
    private String adminName;
    @Column (name = "admin_email", unique = true, nullable = false)
    private String adminEmail;
    @Column (name = "admin_otp")
    private String adminOtp;
}
