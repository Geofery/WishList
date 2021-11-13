package com.example.createhtmlobjects.Service;


import com.example.createhtmlobjects.MyObjects.Person;

/**
 * @author roed
 */
public class PersonService {
  public Person addPerson(String name, int age){
    Person person = new Person(name,age);
    return person;
  }
}
