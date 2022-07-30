package com.example.demo.exception;

public class CustomExceptionSchema {

    private String message;
    private String description;

    public CustomExceptionSchema(String message, String description) {
        this.message = message;
        this.description = description;
    }

    public CustomExceptionSchema(String message) {
        this.message = message;
    }

    public CustomExceptionSchema() {
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
