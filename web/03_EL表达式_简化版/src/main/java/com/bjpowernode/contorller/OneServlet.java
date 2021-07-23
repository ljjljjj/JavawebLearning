package com.bjpowernode.contorller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.向当前用户session添加一个共享数据
        HttpSession session = request.getSession();
        session.setAttribute("key","菲菲");

        //2.向当前请求作用域对象添加一个共享数据
        request.setAttribute("key","李白");

        //3.请求转发，申请调用index_1.jsp
        request.getRequestDispatcher("/index_1.jsp").forward(request,response);

    }
}
