package com.bjpowernode.controller;

import com.bjpowernode.entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student stu = new Student(10,"mike" );
        request.setAttribute("key",stu);
        request.getRequestDispatcher("/index_1.jsp").forward(request,response);
    }

}
