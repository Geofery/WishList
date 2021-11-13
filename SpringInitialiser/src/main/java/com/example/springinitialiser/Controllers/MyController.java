package com.example.springinitialiser.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

/**
 * @author roed
 */
@Controller
public class MyController {


  @GetMapping("/")
  public String  index(){
    return "index";
  }

  @GetMapping("/about")
  public String about(){
    return "about";
  }
  @GetMapping("/date")
  public String date(){
    return "date";
  }

  @GetMapping("/av")
  public String push(@RequestParam String fname, Model model){
    model.addAttribute("name", fname);
    return "result";
  }

}
