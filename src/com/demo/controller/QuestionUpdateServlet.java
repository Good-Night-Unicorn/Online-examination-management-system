package com.demo.controller;

import com.demo.dao.QuestionDao;
import com.demo.ontity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class QuestionUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title, optionA, optionB, optionC, optionD, answer, questionID;
        QuestionDao questionDao = new QuestionDao();
        Question question = null;
        int result = 0;
//调用请求对象读取请求头参数信息。
        title = request.getParameter("title");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");
        questionID = request.getParameter("questionID");
//调用Dao实现更新操作。
        question = new Question(Integer.valueOf(questionID), title, optionA, optionB, optionC, optionD, answer);
        result = questionDao.update(question);
//调用info.jsp将操作结果写入响应体
        if (result == 1) {
            request.setAttribute("info", "试题更新成功");
        } else {
            request.setAttribute("info", "试题更新失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
}



