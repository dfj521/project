package com.dfj.controller;

import com.dfj.entity.User;
import com.dfj.exception.PasswordException;
import com.dfj.exception.UsernameException;
import com.dfj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/*
    Controller层
    接收请求，调用service的处理结果，做出相应
 */
@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @ExceptionHandler
    public String handlerException(Exception e, HttpServletRequest request) throws Exception {
        if (e instanceof UsernameException || e instanceof PasswordException) {
            //业务异常需要自己处理
            request.setAttribute("message",e.getMessage());
            return request.getServletPath().split("\\.")[0];
        }else if (e instanceof EmptyResultDataAccessException){
            request.setAttribute("message","账号不存在");
            return request.getServletPath().split("\\.")[0];
        }else {
            //系统异常
            throw e;
        }
    }

    @RequestMapping("toRegister.do")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("register.do")
    public String register(User user, HttpSession session) {
        userService.add(user);
        session.setAttribute("user", user);
        return "login";
    }

    @RequestMapping("toLogin.do")
    //因为login在WEB-INF下面，不能够直接访问，需要发送请求进行转发进去
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toIndex.do")
    public String toIndex(ModelMap modelMap) {
        List<User> userList = userService.findAll();
        modelMap.addAttribute("userList",userList);
        return "index";
    }

    @RequestMapping("/login.do")
    public String login(String username, String password, HttpSession session) {
        User user = userService.checkLogin(username, password);
        //成功认证后，会将身份信息放到session中
        session.setAttribute("user", user);
        //成功登录后跳转到主页面
        return "redirect:toIndex.do";
    }

    @RequestMapping("/exit.do")
    public String exit(HttpSession session) {
        session.invalidate();
        return "redirect:toLogin.do";
    }

}
