package com.dfj.interceptor;

import com.dfj.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    登录拦截的思路：
        如果用户成功登录，信息会保存到session中。
        如果用户不登录，直接访问内部页面，此时拦截器就会将其拦下并将其重定向到登录页面。
        所以用户成功登录后一定要将其信息保存在session中，方便以后的session认证。
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //用户信息为空，重定向到登录页面
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/toLogin.do");
            return false;
        }
        //用户一定是认证过的
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
