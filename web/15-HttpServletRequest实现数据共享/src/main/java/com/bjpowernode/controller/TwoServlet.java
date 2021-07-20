package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从同一个请求作用域对象得到OneServlet写入到共享数据
        String value = (String)request.getAttribute("key1");
        System.out.println("TwoServlet得到共享数据："+value);
    }
}
