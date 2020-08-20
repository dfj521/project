package com.dfj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello.do")
    public String hello() {
        int i = 1/0;
        return "hello";
    }

    @RequestMapping("/login.do")
    public String login(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        return "hello";
    }

    @RequestMapping("/toLogin.do")
    public String toLogin() {
        return "login";
    }

}
