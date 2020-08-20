package com.dfj.controller;

import com.dfj.entity.Admin;
import com.dfj.response.AdminRequest;
import com.dfj.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AdminController {

    @Resource
    private AdminService adminService;

    @GetMapping("/admin.do")
    public List<Admin> findAll() {
        return adminService.findAll();
    }

    @GetMapping("/admin/{id}.do")
    public Admin findById(@PathVariable("id") Integer id) {
        return adminService.findById(id);
    }
}
