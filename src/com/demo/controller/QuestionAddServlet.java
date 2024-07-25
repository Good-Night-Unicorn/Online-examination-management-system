package com.demo.controller;

import com.demo.dao.QuestionDao;
import com.demo.ontity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class QuestionAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title, optionA, optionB, optionC, optionD, answer;
        QuestionDao questionDao = new QuestionDao();
        Question question = null;
        PrintWriter out = null;
        int result = 0;
//调用请求对象读取信息，得到新增信息内容
        title = request.getParameter("title");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");

//        调用Dao对象将insert命令推送到数据库，并得到处理结果
        question = new Question(null, title, optionA, optionB, optionC, optionD, answer);
        result = questionDao.add(question);

//        通过请求转发，向tomcat索要info.jsp将处理结果写入响应体
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        if (result == 1) {
            request.setAttribute("info", "试题添加成功");
        } else {
            request.setAttribute("info", "试题添加失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }

}
