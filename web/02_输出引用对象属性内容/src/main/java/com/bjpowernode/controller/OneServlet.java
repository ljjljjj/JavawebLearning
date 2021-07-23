package com.bjpowernode.controller;

import com.bjpowernode.entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建一个引用类型对象
        Student student = new Student(20,"allen");
        //2.将引用类型对象存入到请求作用域作为共享数据
        request.setAttribute("key",student);
        //3.请求转发，向Tomcat申请调用index_1.jsp
        request.getRequestDispatcher("/index_1.jsp").forward(request,response);

    }
}
