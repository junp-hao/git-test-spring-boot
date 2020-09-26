package com.example.springboot.exception;

public class UserNoExistException extends RuntimeException{
    public UserNoExistException() {
        super("用户不存在");
    }
}
