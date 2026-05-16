package com.manhpt.springcore.rest;

import com.manhpt.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for dependency
    private Coach myCoach;

    @Autowired
    public DemoController (Coach theCoach){
        myCoach = theCoach;
    }
    // Giữa @Qualifier và @Primary để chỉ định dependency injection
    // thì nên dùng @Qualifer vì nó ưu tiên cao hơn, rõ ràng hơn

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
