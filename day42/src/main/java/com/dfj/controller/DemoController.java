package com.dfj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DemoController {
    //使用ModelAndView实现跳转页面并传出数据
    @RequestMapping("test.do")
    public ModelAndView test() {
        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        map.put("message","操作成功");
        return new ModelAndView("test",map);
    }
    //使用ModelMap传出数据
    @RequestMapping("test1.do")
    public ModelAndView test1(ModelMap modelMap) {
        modelMap.addAttribute("success",false);
        modelMap.addAttribute("message","操作失败");
        return new ModelAndView("test");
    }
    //使用@ModelAttribute传出bean属性
    @ModelAttribute("age")
    public int getAge() {
        return 81;
    }
    //使用@ModelAttribute传出参数值
    @RequestMapping("test2.do")
    public ModelAndView test2(@ModelAttribute("userName") String userName) {
        return new ModelAndView("test");
    }
    //使用Session传出数据
    @RequestMapping("test3.do")
    public ModelAndView test3(HttpSession session, String username) {
        session.setAttribute("username", username);
        session.setAttribute("salary", 66666);
        return new ModelAndView("test");
    }
    //返回String并返回数据
    @RequestMapping("test4.do")
    public String test4(String job, ModelMap modelMap) {
        modelMap.addAttribute("job", job);
        return "test";
    }
    //系统错误页面
    @RequestMapping("/test5.do")
    public String test5() {
        return "error";
    }
    //使用RedirectView实现重定向
    @RequestMapping("/test6.do")
    public ModelAndView test6(String username, String password) {
        if ("zs".equals(username) && "123".equals(password)) {
            //账号和密码正确 则转发到test页面
            return new ModelAndView("test");
        }else {
            //账号和密码错误 则重定向到错误页面
            return new ModelAndView(new RedirectView("test5.do"));
        }
    }
    //使用Redirect实现重定向
    @RequestMapping("/test7.do")
    public String test7(String username, String password) {
        if ("zs".equals(username) && "123".equals(password)) {
            return "test";
        }else {
            return "redirect:test5.do";
        }
    }
}
