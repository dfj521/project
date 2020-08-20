package com.dfj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestFul {
    @RequestMapping("/restful")
    public String restful() {
        return "restful.html";
    }
}
