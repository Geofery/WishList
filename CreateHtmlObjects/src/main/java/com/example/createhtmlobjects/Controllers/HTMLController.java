package com.example.createhtmlobjects.Controllers;

import com.example.createhtmlobjects.MyObjects.Person;
import com.example.createhtmlobjects.Service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


/**
 * @author roed
 */

@Controller
public class HTMLController {
  PersonService personService;
  ArrayList<Person> people = new ArrayList<>();

  public HTMLController() {
    this.personService = new PersonService();
    people.add(new Person("Mike", 30));
    people.add(new Person("Dennis", 45));
    people.add(new Person("Christopher", 29));
  }

  @GetMapping("/")
  public String getPeople(Model model){
    model.addAttribute("people", people);
    return "person";
  }

  @PostMapping("/addPerson")
  public String addPerson(@RequestParam String name, @RequestParam int age, Model model){
    people.add(personService.addPerson(name, age));
    model.addAttribute("people", people);
    return "person";
  }
}
