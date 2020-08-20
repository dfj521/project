package com.dfj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//配置Controller
@Controller
public class HelloController {

    //映射请求
    @RequestMapping("/hello.do")
    public ModelAndView hello() {
        //返回的视图
        return new ModelAndView("hello");
    }

}
