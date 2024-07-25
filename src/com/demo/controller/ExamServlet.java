package com.demo.controller;

import com.demo.ontity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ExamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        List<Question> questionList = null;
//从当前用户私人储物柜得到系统提供的四道题目信息
        questionList = (List<Question>) session.getAttribute("key");
        int score = 0;
//        从请求包读取对于四道题目给出的答案
        for (Question question : questionList) {
            String answer = question.getAnswer();
            Integer questionID = question.getQuestionID();
            String userAnswer = request.getParameter("answer_" + questionID);
            if (userAnswer.equals(answer)) {
                score += 25;
            }
        }


//        将分数写入到request中，作为共享数据
        request.setAttribute("info", "本次考试成绩" + score);
//        请求转发调用jsp将用户本次考试分数写入到响应体
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
