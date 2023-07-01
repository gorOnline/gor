package com.app.gorworld.service;

import com.app.gorworld.model.enums.PLAN;
import org.springframework.stereotype.Service;

@Service
public class GorUtilService {


    public PLAN convertToPLAN(String plan) {
       return PLAN.valueOf(plan);
    }
}
