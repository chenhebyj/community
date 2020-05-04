package com.example.demo.advice;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    DATA_NOT_FOUND("你要找的问题不在了！！！");

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }

}
