package com.demo.controller;

import com.demo.dao.QuestionDao;
import com.demo.ontity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class QuestionFindByIDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionID;
        QuestionDao questionDao=new QuestionDao();
        Question question=null;
//调用请求对象读取请求头中参数信息，得到试题编号
        questionID= request.getParameter("questionID");
//        调用Dao推送查询命令得到这个试题编号对应的试题信息
        question =questionDao.findByID(questionID);
//        调用question_update.jsp将试题信息写入到响应体
        request.setAttribute("key1",question);
        request.getRequestDispatcher("/question_update.jsp").forward(request,response);

    }

}
