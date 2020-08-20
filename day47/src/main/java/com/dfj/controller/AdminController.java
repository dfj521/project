package com.dfj.controller;

import com.dfj.entity.Admin;
import com.dfj.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {

    @Resource
    private AdminService adminService;

    //注册页面
    @RequestMapping("/register.do")
    public String register() {
        return "register";
    }

    //注册校验
    @RequestMapping("/registerCheck.do")
    public String registerCheck(Admin admin, ModelMap modelMap) {
        Admin byName = adminService.findByName(admin.getUsername());
        if (byName != null) {
            modelMap.addAttribute("usernameError", "用户名已存在");
            return "register";
        }
        adminService.save(admin);
        return "redirect:/adminList.do";
    }

    //登录页面
    @RequestMapping("/login.do")
    public String login() {
        return "login";
    }

    //登录校验
    @RequestMapping("/loginCheck.do")
    public String loginCheck(String account, String password, ModelMap modelMap, HttpSession session) {
        Admin admin = adminService.findByName(account);
        if (admin == null) {
            admin = adminService.findByEmail(account);
            if (admin == null) {
                admin = adminService.findByTelephone(account);
                if (admin == null) {
                    modelMap.addAttribute("usernameError", "账号不存在");
                    return "login";
                }
            }
        }
        if (!admin.getPassword().equals(password)) {
            modelMap.addAttribute("passwordError", "密码错误");
            return "login";
        }
        session.setAttribute("admin", admin);
        return "redirect:/list.do";
    }

    //管理系统页面
    @RequestMapping("/list.do")
    public String list() {
        return "list";
    }

    //管理员信息页面
    @RequestMapping("/adminList.do")
    public String adminList(ModelMap modelMap) {
        List<Admin> adminList = adminService.findAll();
        modelMap.addAttribute("adminList", adminList);
        return "adminList";
    }

    //修改管理员信息
    @RequestMapping("/adminUpd.do")
    public String adminUpd(Integer id, ModelMap modelMap) {
        Admin admin = adminService.findById(id);
        modelMap.addAttribute("admin", admin);
        return "adminUpd";
    }

    //修改管理员信息校验
    @RequestMapping("/adminUpdCheck.do")
    public String adminUpdCheck(Admin admin, ModelMap modelMap) {
        Admin byName = adminService.findByName(admin.getUsername());
        if (byName != null && !byName.getUsername().equals(admin.getUsername())) {
            modelMap.addAttribute("usernameError", "用户名已存在");
            modelMap.addAttribute("admin", admin);
            return "adminUpd";
        }
        adminService.update(admin);
        return "redirect:/adminList.do";
    }

    //删除管理员信息
    @RequestMapping("/adminDel.do")
    public String adminDel(Integer id) {
        adminService.delete(id);
        return "redirect:/adminList.do";
    }

    //登出
    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.do";
    }

    //根据条件查询数据
    @RequestMapping("/findByOption.do")
    public String findByOption(Admin admin, ModelMap modelMap) {
        List<Admin> adminList = adminService.findByOption(admin);
        modelMap.addAttribute("adminList", adminList);
        modelMap.addAttribute("adminOption", admin);
        return "adminList";
    }
}
