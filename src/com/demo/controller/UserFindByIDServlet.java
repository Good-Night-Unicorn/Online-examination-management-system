package com.demo.controller;

import com.demo.dao.UserDao;
import com.demo.ontity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UserFindByIDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID;
        UserDao userDao = new UserDao();
        Users users = null;
//调用请求对象读取请求头中参数信息，得到试题编号
        userID = request.getParameter("userID");
//        调用Dao推送查询命令得到这个试题编号对应的试题信息
        users = userDao.findByID(userID);
//        调用question_update.jsp将试题信息写入到响应体
        request.setAttribute("key1", users);
        request.getRequestDispatcher("/user_update.jsp").forward(request, response);
    }


}
