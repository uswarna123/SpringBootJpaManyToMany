package com.example.demo.exception;

import java.util.Date;

public class ErrorMessage {
    private int statusCode;
    private Date timestamp;
    private String errorMsg;
    private String description;

    public ErrorMessage(int statusCode, Date timestamp, String errorMsg, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.errorMsg = errorMsg;
        this.description = description;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String getDescription() {
        return description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
