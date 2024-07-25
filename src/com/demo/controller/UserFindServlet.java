package com.demo.controller;

import com.demo.dao.UserDao;
import com.demo.ontity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        PrintWriter out = null;
        //提供服务
//调用dao将查询命令推送到数据库服务器上，得到所有用户信息【list】
        List<Users> userlist = userDao.findAll();
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        out.println("<table  border='2' align='center'>");
        out.println("<tr>");
        out.println("<td>用户编号</td>");
        out.println("<td>用户姓名</td>");
        out.println("<td>用户密码</td>");
        out.println("<td>用户性别</td>");
        out.println("<td>用户邮箱</td>");
        out.println("<td>操作</td>");
        out.println("<td>操作</td>");
        out.println("</tr>");
        for (Users user : userlist) {
            out.println("<tr>");
            out.println("<td>" + user.getUserID() + "</td>");
            out.println("<td>" + user.getUserName() + "</td>");
            out.println("<td>" + user.getPassword() + "</td>");
            out.println("<td>" + user.getSex() + "</td>");
            out.println("<td>" + user.getEmail() + "</td>");
            out.println("<td><a href='/myweb/user/delete?userID=" + user.getUserID() + "'>用户删除</a></td>");
            out.println("<td><a href='/myweb/user/findByID?userID=" + user.getUserID() + "'>用户更新 </a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
//调用响应对象将用户信息结合<table>标签命令以二进制形式写入响应体
    }


}
