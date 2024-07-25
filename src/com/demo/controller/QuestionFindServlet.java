package com.demo.controller;

import com.demo.dao.QuestionDao;
import com.demo.ontity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class QuestionFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//调用dao推送查询命令得到所有的是试题
        QuestionDao questionDao = new QuestionDao();
        List<Question> list = questionDao.findAll();
        //将得到试题添加到请求作用域对象作为共享数据
        request.setAttribute("key1", list);
//请求转发向tomcat调用questions.jsp将结果与html标签写入响应体
        request.getRequestDispatcher("/questions.jsp").forward(request, response);
    }


}
