package com.example.fitgym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MembersDto {
    private Long memberId;
    private String memberName;
    private String memberEmail;

    private Long memberPhone;
    private String gymPlan;

    private Double paidAmount;
    private Double paidBalance;
    private Double totalAmount;
}
