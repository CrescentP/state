package com.caopeng.state.config;/**
 * @author Crescent_P
 * @date 2021-05-24 16:50
 */

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置过滤器,必须登录才能进去
 * @author Crescent_P
 * @date 2021-05-24 16:50
 *
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userSession = request.getSession().getAttribute("userSession");
        System.out.println("Debug==> " + userSession);
        if(userSession == null){
            System.out.println("没有权限");
            request.setAttribute("msg","没有权限,请先登录");
            response.sendRedirect(request.getContextPath()+"/goLogin");
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
