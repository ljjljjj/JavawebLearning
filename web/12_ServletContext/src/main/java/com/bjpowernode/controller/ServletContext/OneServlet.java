package com.bjpowernode.controller.ServletContext;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.通过请求对象向tomcat索要当前网站全局作用域对象
        ServletContext application = request.getServletContext();
        //2.将数据添加到全局作用域对象，作为共享数据
        application.setAttribute("key1",100);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
