package com.dfj.controller;

import com.dfj.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//DemoController里面的方法返回值全部用Json
@RestController //@RestController = @Controller + @ResponseBody
public class DemoController {
    @RequestMapping("/hello.do")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/map.do")
    public Map map() {
        HashMap map = new HashMap();
        map.put("name","hh");
        map.put("age",18);
        return map;
    }

    @RequestMapping("/find.do")
    public User find() {
        User user = new User();
        user.setUsername("jack");
        user.setPassword("123");
        return user;
    }

    @RequestMapping("/list.do")
    public List<String> list() {
        List<String> list = new ArrayList<>();
        list.add("jerry");
        list.add("tom");
        list.add("jack");
        return list;
    }

    @RequestMapping("/findAll.do")
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            User user = new User();
            user.setUsername("a" + i);
            user.setPassword("123");
            userList.add(user);
        }
        return userList;
    }
}
