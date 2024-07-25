package com.demo.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Onefilter extends filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//拦截后，通过请求对象向tomcat索要当前对象的HttpSession
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = null;

//         调用请求对象读取请求包中请求行中uri，了解用户访问资源文件是谁
        String uri = request.getRequestURI();//资源文件名
//        如果本次请求资源文件与登录相关此时应该无条件放弃。
        if (uri.indexOf("login") != -1 || "/myweb/".equals(uri)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
//如果本次访问的是其他资源文件，需要得到用户在服务端的HttpSession

        session = request.getSession(false);
        if (session != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            request.getRequestDispatcher("/login_error.html").forward(servletRequest, servletResponse);
            return;
        }

    }

}
