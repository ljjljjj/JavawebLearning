package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.分别将共享数据添加到作用域对象
        ServletContext application = request.getServletContext();
        HttpSession session = request.getSession();
        //将三个共享数据分别放到三个作用域中
        application.setAttribute("sid",10);//向全局作用域
        session.setAttribute("sname","mike");//向当前(会话)作用域
        request.setAttribute("home","北京");//向请求作用域


        //2.通过请求转发方式，向Tomcat申请调用index_1.jsp,有index_1.jsp负责
        //将作用域对象共享数据读取并写入到响应体中，交给浏览器
        request.getRequestDispatcher("index_1.jsp").forward(request,response);

    }
}
