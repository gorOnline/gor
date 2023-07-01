package com.app.gorworld.config;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSAsync;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

import java.util.HashMap;
import java.util.Map;


public class AmazonSNSConfig {
    public static final String  AWS_ACESS_KEY_ID = "aws.accessKeyId";
    public static final String  AWS_SECRET_KEY = "aws.secretKey";

    static{
//        System.setProperty(AWS_ACESS_KEY_ID, "AKIA3B25MN2WUGJQHHSN");
//        System.setProperty(AWS_SECRET_KEY, "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");
    }
}
