package com.app.gorworld.controller;

import com.app.gorworld.dto.OtpRequestDto;
import com.app.gorworld.dto.OtpResponseDto;
import com.app.gorworld.service.SMSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class SMSController {
    Logger log = LoggerFactory.getLogger(SMSController.class);
    @Autowired
    SMSService smsService;

    @PostMapping("/otp")
    public ResponseEntity<?> sendOtp(@RequestBody OtpRequestDto otpRequestDto) {
        try {
            OtpResponseDto otp = smsService.sendOtp(otpRequestDto.getMobileNumber());
            return new ResponseEntity<>(otp, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
