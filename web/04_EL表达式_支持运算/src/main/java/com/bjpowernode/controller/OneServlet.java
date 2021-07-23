package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("key1","100");
        request.setAttribute("key2",200);

        request.getRequestDispatcher("/index_1.jsp").forward(request, response);


    }


}
