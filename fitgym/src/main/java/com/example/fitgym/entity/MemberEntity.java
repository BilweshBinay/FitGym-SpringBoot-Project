package com.example.fitgym.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "member_table")

public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;
    @Column(name = "member_name")
    private String memberName;
    @Column(name = "member_email")
    private String memberEmail;
    @Column(name = "member_phone")
    private Long memberPhone;
    @Column(name = "gym_plan")
    private String gymPlan;
    @Column(name = "paid_amt")
    private Double paidAmount;
    @Column(name = "balance_amt")
    private Double paidBalance;
    @Column(name = "total_amt")
    private Double totalAmount;
}
