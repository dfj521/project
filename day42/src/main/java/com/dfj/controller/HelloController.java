package com.dfj.controller;

import com.dfj.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    //接收参数：使用HttpServletRequest 接收参数
    @RequestMapping("/hello.do")
    public String hello(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        return "hello";
    }
    //接收参数：直接使用属性值来接收
    //如果前后台参数与属性值不一样 则需要使用注解@RequestParameter()指定
    @RequestMapping("/hello1.do")
    public String hello1(String username, @RequestParam("password")String pwd) {
        System.out.println(username + ":" + pwd);
        return "hello";
    }
    //接收参数：直接使用对象进行接受
    @RequestMapping("/hello2.jsp")
    public String hello2(User user) {
        System.out.println(user);
        return "hello";
    }
}
