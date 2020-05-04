package com.example.demo.exception;

import com.example.demo.advice.ICustomizeErrorCode;

public class CustomizeException extends RuntimeException{
    private String message;



    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
