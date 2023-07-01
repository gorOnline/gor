package com.app.gorworld.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdatePlanDto {
    String mobileNumber;
    String plan;
}
