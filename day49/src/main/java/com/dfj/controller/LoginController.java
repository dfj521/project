package com.dfj.controller;

import com.dfj.response.ResultEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("/checkName")
    @ResponseBody
    public ResultEntity checkName(String username) {
        /**
         * 写死到后台controller
         * TODO:使用JSR302进行后台参数校验
         */
        ResultEntity re = new ResultEntity();
        if (username == null || username.equals("")) {
            re.setMessage("请输入账号");
            re.setStatus(1);
            return re;
        }
        if ("zs".equals(username)) {
            re.setMessage("账号存在，可以使用");
            re.setStatus(0);
            return re;
        }
        re.setMessage("账号不存在");
        re.setStatus(2);
        return re;
    }
}
