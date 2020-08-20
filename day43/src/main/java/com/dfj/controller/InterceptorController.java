package com.dfj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {

    @RequestMapping("/inter.do")
    public String inter() {
        System.out.println("进入Controller之后，视图信息返回之前");
        return "hello";
    }

}
