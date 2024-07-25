package com.demo.controller;

import com.demo.dao.QuestionDao;
import com.demo.ontity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class QuestionRandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao questionDao = new QuestionDao();
        List<Question> list = null;
        HttpSession session = request.getSession(false);
//调用Dao对象随机从question表拿出4道题目
        list = questionDao.findRand();
//        将4道题目添加到request作为共享数据
        session.setAttribute("key", list);
//        请求转发，申请掉exam.jsp将4道题目写入到响应体
        request.getRequestDispatcher("/exam.jsp").forward(request, response);
    }


}
