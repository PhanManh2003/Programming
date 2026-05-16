package com.manhpt.springcore.rest;

import com.manhpt.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for dependency
    private Coach myCoach;

    @Autowired
    // Khi Spring thấy @Autowired trên setter/method, nó sẽ tự gọi method đó và truyền dependency phù hợp vào.
    // đặt tên hàm là gì cx dc , ko cứ phải là setCoach
    public void setMyCoach(Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
