package com.app.gorworld.controller;

import com.app.gorworld.dto.PlanResponseDto;
import com.app.gorworld.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("plan")
public class PlansController {

    @Autowired
    PlanService planService;

    @PostMapping()
    public List<PlanResponseDto> getPlans(){
        return planService.getPlans();
    }

}
