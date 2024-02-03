package com.spring.validation.springvalidation.exceptionHandling;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgsValidaitons(MethodArgumentNotValidException methodArgumentNotValidException)
    {
        List<String> msg=methodArgumentNotValidException.getFieldErrors().stream().map(err -> err.getDefaultMessage()).collect(Collectors.toList());
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }

//    @org.springframework.web.bind.annotation.ExceptionHandler(HttpMediaTypeNotSupportedException.class)
//    public ResponseEntity<?> handleHttpMediaType(HttpMediaTypeNotSupportedException httpMediaTypeNotSupportedException)
//    {
//       String res= httpMediaTypeNotSupportedException.getMessage();
//        return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
//    }
}
