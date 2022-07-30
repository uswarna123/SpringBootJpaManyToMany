package com.example.demo.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.Date;

@ControllerAdvice
public class ExceptionHandlerConfig {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResourceNotFoundException resourceNotFoundException(ResourceNotFoundException ex){
           ResourceNotFoundException exception=new ResourceNotFoundException(ex.getMessage());
        return exception;
    }

    @ExceptionHandler(BadRrequestException.class)
    public BadRrequestException badRequestException(BadRrequestException ex){
        BadRrequestException exception=new BadRrequestException(ex.getMessage());
        return exception;
    }

    @ExceptionHandler(Exception.class)
    public Exception globalExceptionHandler(Exception ex){
        Exception exception=new Exception(ex.getMessage());
        return exception;
    }
}
