package com.dfj.controller;

import com.dfj.entity.User;
import com.dfj.exception.LoginException;
import com.dfj.exception.RegistException;
import com.dfj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ExceptionHandler
    public String handlerException(Exception e, HttpServletRequest request) throws Exception {
        if (e instanceof LoginException) {
            request.setAttribute("message", e.getMessage());
            return "login";
        } else if (e instanceof RegistException) {
            request.setAttribute("message", e.getMessage());
            return "regist";
        } else {
            throw e;
        }
    }

    //登出
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }

    //注册页面
    @RequestMapping("regist")
    public String register() {
        return "regist";
    }

    //注册操作
    @RequestMapping("registeredSuccessfully")
    public String registeredSuccessfully(User user) {
        System.out.println(user);
        userService.add(user);
        return "redirect:login";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("index")
    public String index(String username, String password, ModelMap modelMap, HttpSession session) {
        try {
            User user = userService.findByName(username);
            if (user.getPassword().equals(password)) {
                session.setAttribute("user", user);
                List<User> userList = userService.findAll();
                modelMap.addAttribute("userList", userList);
                return "index";
            }else {
                throw new LoginException("密码错误");
            }
        } catch (EmptyResultDataAccessException e) {
            throw new LoginException("账号不存在");
        }
    }

}
