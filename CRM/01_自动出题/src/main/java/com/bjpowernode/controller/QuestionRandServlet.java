package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class QuestionRandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        List questionList = null;
        HttpSession session = request.getSession(false);
        //1.调用Dao对象随机从question表中取出四道题目
        questionList = dao.findRand();
        //2.将四道题目添加到request作为共享数据
        session.setAttribute("key",questionList);
        //3.请求转发，申请调exam.jsp将四道题目写入到响应体
        request.getRequestDispatcher("/exam.jsp").forward(request,response);

    }
}
