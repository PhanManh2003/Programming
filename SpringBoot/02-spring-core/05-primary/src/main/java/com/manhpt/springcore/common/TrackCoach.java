package com.manhpt.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "track coach training everyday.";
    }
}
