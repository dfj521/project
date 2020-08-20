package com.dfj.controller;

import com.dfj.entity.User;
import com.dfj.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/toIndex")
    public String toIndex(String username, String password, ModelMap modelMap, HttpSession session) {
        User user = userService.findByNameAndPwd(username, password);
        if (user == null) {
            modelMap.addAttribute("message", "账号或密码错误");
            return "login";
        } else {
            session.setAttribute("user", user);
            return "redirect:/list";
        }
    }

    @RequestMapping("/registerSuccess")
    public String registerSuccess(User user, ModelMap modelMap) {
        User byName = userService.findByName(user.getUsername());
        if (byName != null) {
            modelMap.addAttribute("message", "用户名已存在");
            return "register";
        } else {
            userService.add(user);
            return "redirect:/login";
        }
    }

    @RequestMapping("/update")
    public String update(User user) {
        userService.updById(user);
        return "redirect:/list";
    }

    @RequestMapping("/updInfo")
    public String updInfo(Integer id,ModelMap modelMap) {
        User user = userService.findById(id);
        modelMap.addAttribute("user", user);
        return "modification";
    }

    @RequestMapping("/delInfo")
    public String delInfo(Integer id) {
        userService.delById(id);
        return "redirect:/list";
    }

    @RequestMapping("/option")
    public String option(User user, ModelMap modelMap) {
        List<User> userList = userService.findByOption(user);
        modelMap.addAttribute("option", user);
        modelMap.addAttribute("userList", userList);
        return "index";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        List<User> userList = userService.findAll();
        modelMap.addAttribute("userList", userList);
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
