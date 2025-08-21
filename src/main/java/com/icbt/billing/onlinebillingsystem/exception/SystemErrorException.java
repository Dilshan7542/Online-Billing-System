package com.icbt.billing.onlinebillingsystem.exception;

public class SystemErrorException extends RuntimeException {
    String message;
    public SystemErrorException(String message) {
        super(message);
    }

    public SystemErrorException() {
        message="System Error";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
