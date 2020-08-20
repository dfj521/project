package com.dfj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello.do")
    public String hello() {
        //Integer.valueOf("abc");
        System.out.println("执行Controller方法");
        return "hello";
    }
}
