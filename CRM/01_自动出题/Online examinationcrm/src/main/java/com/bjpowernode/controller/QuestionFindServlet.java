package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class QuestionFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QuestionDao dao = new QuestionDao();
        //1.调用DAO推送查询命令得到所有的试题
        List list = dao.findAll();
        //2.将得到试题添加到请求作用域对象作为共享数据
        request.setAttribute("key",list);
        //3.请求转发向Tomcat调用question.jsp 将结果与html标签写入响应体
        request.getRequestDispatcher("/question.jsp").forward(request,response);

    }
}
