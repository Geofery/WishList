package Controllers;

import needName.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

/**
 * @author roed
 */
@Controller
public class HTMLController {

  @GetMapping("/createAccount")
  public String createAccount() {
  //model.addAttribute("createUser", new User());
    return "login";
  }

 /* @GetMapping("/login")
  public String login(){

    return "login";
  }*/

}
