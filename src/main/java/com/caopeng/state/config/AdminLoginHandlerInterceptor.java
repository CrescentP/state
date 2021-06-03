package com.caopeng.state.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Crescent_P
 * @date 2021-05-25 08:02:45
 * @return
 **/

public class AdminLoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object rootSession = request.getSession().getAttribute("rootSession");
//        System.out.println(rootSession);
        System.out.println("AdminLoginHandlerInterceptor Debug==> rootSession" + rootSession);
        if(rootSession == null){
            System.out.println("管理员没有权限");
            request.setAttribute("msg","没有权限,请先登录");
            response.sendRedirect(request.getContextPath()+"/admin/goLogin");
//            request.getRequestDispatcher("/Login.html").forward(request, response);
            return false;
        }else return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
