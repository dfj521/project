package com.dfj.exception;

/*
    自定义异常：账号不存在异常
 */
public class UsernameException extends RuntimeException{

    public UsernameException(String message) {
        super(message);
    }

}
