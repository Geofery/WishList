package com.example.demo.needName;

/**
 * @author roed
 */
public class UserNotFoundException extends Throwable {
  public UserNotFoundException(String message) {
    super(message);
  }
}
