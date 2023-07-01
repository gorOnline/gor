package com.app.gorworld.service;

import com.app.gorworld.dto.PlanResponseDto;
import com.app.gorworld.model.enums.PLAN;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanService {

    public List<PlanResponseDto> getPlans(){
        return Arrays.stream(PLAN.values()).map(this::convertPlan2PlanResponseDto).collect(Collectors.toList());
    }

    private PlanResponseDto convertPlan2PlanResponseDto(PLAN p){
        PlanResponseDto res = new PlanResponseDto();
        res.setName(p.getName());
        res.setMonths(p.getDays());
        res.setOffer(p.getOffer());
        res.setPrice(p.getPrice());
        res.setTotal(p.getTotal());
        return res;
    }
}
