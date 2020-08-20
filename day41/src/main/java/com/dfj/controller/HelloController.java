package com.dfj.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        /*
            TODO调用service业务逻辑层方法
         */
        //ModelAndView:数据和视图 封装了数据和视图的信息
        return new ModelAndView("hello");
    }
}
