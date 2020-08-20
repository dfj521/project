package com.dfj.controller;

import com.dfj.entity.Admin;
import com.dfj.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class AdminController {

    @Resource
    private AdminService adminService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping(value = "/admin")
    @ResponseBody
    public List<Admin> list() {
        return adminService.findAll();
    }
}
