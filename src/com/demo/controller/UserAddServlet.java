package com.demo.controller;

import com.demo.dao.UserDao;
import com.demo.ontity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName, password, sex, email;
        UserDao dao = new UserDao();
        Users user = null;
        int result = 0;
        PrintWriter out = null;
        //1.[调用请求对象]读取【请求头】中参数信息。得到用户信息
        userName = request.getParameter("username");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
        //* 2【调用userdao】将用户信息填充到insert命令并借助jdbc规范发送到数据库服务器
        user = new Users(null, userName, password, sex, email);
        Date starDate = new Date();
        result = dao.add(user, request);
        Date endDate = new Date();
        System.out.println("添加消耗时间" + (endDate.getTime() - starDate.getTime()) + "毫秒");
//* 3【调用响应对象】 将【处理结果】以二进制形式写入到响应体

        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if (result == 1) {
            out.println("<font style='color:red;font-size:40'>用户信息注册成功</font>");
        } else {
            out.println("<font style='color:red;font-size:40'>用户信息注册失败</font>");
        }
//* tomcat负责销毁【请求对象，响应对象】
//*tomcat负责将http响应协议包推送到发送请求的浏览器上
//* 浏览器根据响应头content-type指定编译器对响应体二进制内容编辑
//* 浏览器将编译后结果在窗口中展示给用户  */
    }


}
