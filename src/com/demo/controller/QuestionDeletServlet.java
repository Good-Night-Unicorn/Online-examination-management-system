package com.demo.controller;

import com.demo.dao.QuestionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class QuestionDeletServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionID;
        QuestionDao user = new QuestionDao();
        int result = 0;
        PrintWriter out = null;
//调用请求对象读取请求头参数（用户编号）
        questionID = request.getParameter("questionID");

//调用DAO将用户编号填充到delete命令并发送到数据库服务器
        result = user.delete(questionID);

//调用响应对象将处理结果以二进制写入到响应体中，交给浏览器。
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if (result == 1) {
            out.println("<font style='color:red;font-size:40'>试题息删除成功</font>");
        } else {
            out.println("<font style='color:red;font-size:40'>试题删除失败</font>");
        }
    }


}