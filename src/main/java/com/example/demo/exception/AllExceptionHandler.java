package com.example.demo.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class AllExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException
            (ResourceNotFoundException exception, WebRequest webRequest){
        ErrorMessage errorMessage=new
                ErrorMessage(HttpStatus.NOT_FOUND.value(),
                new Date(),
                exception.getMessage(),
                webRequest.getDescription(false));

        return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRrequestException.class)
    public ResponseEntity<ErrorMessage> badRequestException
            (ResourceNotFoundException exception, WebRequest webRequest){
        ErrorMessage errorMessage=new
                ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                new Date(),
                exception.getMessage(),
                webRequest.getDescription(false));

        return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ErrorMessage globalExceptionHandler(Exception ex,WebRequest request){
        ErrorMessage errorMessage=new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return errorMessage;
    }
}
