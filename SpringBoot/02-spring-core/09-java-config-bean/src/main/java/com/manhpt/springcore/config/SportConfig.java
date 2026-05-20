package com.manhpt.springcore.config;

import com.manhpt.springcore.common.Coach;
import com.manhpt.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    public SportConfig() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Bean("water")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
