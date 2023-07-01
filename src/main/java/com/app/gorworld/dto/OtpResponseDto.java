package com.app.gorworld.dto;

import com.amazonaws.services.sns.model.PublishResult;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OtpResponseDto {
    private String otp;
    private PublishResult result;
}
