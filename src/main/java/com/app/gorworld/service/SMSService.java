package com.app.gorworld.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.app.gorworld.dto.OtpResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SMSService {
    @Value("${aws.accessKeyId}")
    private String accessKeyId;
    @Value("${aws.secretKey}")
    private String secretKey;

    public OtpResponseDto sendOtp(String phoneNumber) {
        String otp = createOtp();
        PublishResult publishResult = sendSingleSms(createOtpMessage(otp), phoneNumber);
        return new OtpResponseDto(otp, publishResult);
    }

    private String createOtpMessage(String otp) {
        return "Your Gor Verification Code is " + otp;
    }

    private String createOtp() {
        Random rnd = new Random();
        int number = rnd.nextInt(9999);
        return String.format("%04d", number);
    }

    public PublishResult sendSingleSms(String msg, String phoneNumber) {
        AWSCredentials credentials = new BasicAWSCredentials(accessKeyId, secretKey);
        AmazonSNS sns = AmazonSNSClient.builder()
                .withRegion(Regions.AP_NORTHEAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        PublishResult res = sns.publish(new PublishRequest()
                .withMessage(msg)
                .withPhoneNumber(phoneNumber));

        return res;
    }
}
