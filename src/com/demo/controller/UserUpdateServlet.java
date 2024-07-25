package com.demo.controller;

import com.demo.dao.UserDao;
import com.demo.ontity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName, password, sex, email, userID;
        UserDao userDao = new UserDao();
        Users users = null;
        int result = 0;
//调用请求对象读取请求头参数信息。
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("Email");
        userID = request.getParameter("userID");

//调用Dao实现更新操作。
        users = new Users(Integer.valueOf(userID), userName, password, sex, email);
        result = userDao.update(users);
//调用info.jsp将操作结果写入响应体
        if (result == 1) {
            request.setAttribute("info", "更新成功");
        } else {
            request.setAttribute("info", "更新失败");
        }
        request.getRequestDispatcher("/info1.jsp").forward(request, response);
    }
}

