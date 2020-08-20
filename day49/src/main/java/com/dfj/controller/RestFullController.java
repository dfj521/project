package com.dfj.controller;

import com.dfj.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
    Http请求 GET/POST/PUT/DELETE四种请求方式对应的controller处理方式
    查询、添加、修改、删除，使用HTTP的不同请求对资源进行唯一的访问
 */
@RestController
@RequestMapping("/user")
public class RestFullController {
    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setUsername("tom" + i);
            user.setPassword("123");
            userList.add(user);
        }
        return userList;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Integer id) {
        User user = new User();
        user.setUsername("h" + id);
        user.setPassword("123");
        return user;
    }

    @RequestMapping(method = RequestMethod.POST)
    public User save(User user) {
        return user;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User update(User user) {
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        return "删除" + id;
    }
}
