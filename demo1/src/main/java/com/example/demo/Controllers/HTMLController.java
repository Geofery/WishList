package com.example.demo.Controllers;

import com.example.demo.needName.User;
import com.example.demo.needName.UserNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import javax.servlet.http.HttpSession;


/**
 * @author roed
 */

@Controller
public class HTMLController {
  UserRepo userRepo = new UserRepo();

  @GetMapping("/register")
  public String register() {
    return "register";
  }

  @GetMapping("/login")
  public String login(Model model) {
    //counter++;
    //model.addAttribute("counter", counter);
    return "login";
  }

  //user kan erstattes med new User()
  @PostMapping("/validateLogin")
  public String validateLogin(WebRequest request, HttpSession session) throws UserNotFoundException {
    User user = new User(request.getParameter("email"), request.getParameter("password"));
    return userRepo.validateUser(user, request, session);
  }

  @PostMapping("/createAccount")
  public String createAccount(WebRequest request) throws UserNotFoundException {
    return userRepo.createAccount(request);
  }

  @PostMapping("/logout")
  public String logOut(HttpSession session){
    return userRepo.logOut(session);
  }

  @ExceptionHandler(Exception.class)
  public String exceptionHandler(Model model, Exception exception){
    model.addAttribute("message", exception.getMessage());
    return "secretPage";
  }
}
