package com.manhpt.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // define method after init and inject dependency
    @PostConstruct
    public void doMyStartUpStuff(){
        System.out.println("In doMyStartUpStuff: " + getClass().getSimpleName());
    }

    // define predestroy method
    // Với bean có scope prototype, Spring không gọi destroy method (@PreDestroy) cho bạn vì spring ko giữ ref của chúng sau khi tạo và inject.
    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println("In doMyCleanUpStuff: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "practice football everyday";
    }
}
