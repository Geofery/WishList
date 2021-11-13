package com.example.learningspring.Services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * @author roed
 */
@RestController
public class HelloSpring {

  @GetMapping("/Hello")
  public String firstMapping(){
    return "Hello Spring";
  }

  @GetMapping("/Parameter")
  public String parameter(@RequestParam String name){
    return name + " Is the name";
  }

 @GetMapping("/Friday")
public String day(){
    Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_WEEK);
    String[] weekDays = {"Sunday","Monday","Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    if (day == Calendar.FRIDAY) {
      return "Yay it's Friday!!!";
    }else
        return "No it's " + weekDays[day-1];
    }

}
