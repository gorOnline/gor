package com.app.gorworld.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyPlanDto {
    private String mobileNumber;

    private Boolean planActive;

    private String message;
}
