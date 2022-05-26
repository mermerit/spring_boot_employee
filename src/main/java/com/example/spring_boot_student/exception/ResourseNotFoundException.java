package com.example.spring_boot_student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends Exception{

    private static final long serialVersion=1L;
    public ResourseNotFoundException(String message){
        super(message);
    }



}
