package com.example.crud1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptionFound extends Exception{
private static final long serialVersionUID = 1L;
public ExceptionFound(String message){
super(message);
}
}