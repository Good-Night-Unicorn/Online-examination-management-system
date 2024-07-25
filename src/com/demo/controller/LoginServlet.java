package com.demo.controller;

import com.demo.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao user = new UserDao();

//        调用请求对象将请求体使用utf-8字符集进行重新编译
        request.setCharacterEncoding("utf-8");
//        调用请求对象读取请求体参数信息
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
//        调用dao将查询验证信息推送到数据库服务器上
        int result = user.login(userName, password);

//        调用相应对象，根据验证结果将不同资源文件地址写入响应头，交给浏览器
        if (result == 1) {
//            在判定来访用户身份合法后，通过请求对象向tomcat申请为当前用户申请一个httpSession
            HttpSession session = request.getSession();
            response.sendRedirect("/myweb/index.html");

        } else {
            response.sendRedirect("/myweb/login_error.html");
        }

    }
}
