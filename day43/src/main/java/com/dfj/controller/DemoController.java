package com.dfj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @ExceptionHandler
    public String handlerException(Exception e, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (e instanceof NumberFormatException) {
            request.setAttribute("message", "亲，请输入数字");
            return "message";
        }else {
            throw e;
        }
    }

    @RequestMapping("/hello.do")
    public String hello() {
        Integer.valueOf("abc");
        return "hello";
    }

    @RequestMapping("/hello1.do")
    public String hello1() {
        "abc".charAt(9);
        return "hello";
    }

}
