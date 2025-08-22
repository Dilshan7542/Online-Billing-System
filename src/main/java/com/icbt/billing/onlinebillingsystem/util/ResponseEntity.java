package com.icbt.billing.onlinebillingsystem.util;

public class ResponseEntity <T>{
    private String status;
    private String message;
    private T data;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseEntity() {
    }

    public ResponseEntity(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseEntity(T data) {
        this.data = data;
    }

    public static <T> ResponseEntity<T> ok() {
        return new ResponseEntity<>();
    }

    public static <T> ResponseEntity<T> ok(T data) {
        return new ResponseEntity<>(data);
    }

    public static <T> ResponseEntity<T> error(String message) {
        return new ResponseEntity<>("500", message, null);
    }

    public static <T> ResponseEntity<T> of(String status, String message, T data) {
        return new ResponseEntity<>(status, message, data);
    }
}
