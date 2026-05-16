package com.manhpt.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Tennis coach training everyday.";
    }
}
