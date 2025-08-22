package com.icbt.billing.onlinebillingsystem.exception;

public class UserNotFoundException extends RuntimeException {
  String message;
    public UserNotFoundException(String message) {
        super(message);
    }

  public UserNotFoundException() {
      message = "User not found";
  }

  @Override
  public String getMessage() {
    return message;
  }
}
