package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class FourServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = "http://www.baidu.com";
        //通过响应对象，将地址赋值给响应头中location属性
        response.sendRedirect(result);//【响应头 location="http://www.baidu.com"】

    }
    /*
    浏览器在接收到响应包后，如果发现响应头存在location属性
    自动通过地址栏向location指定网站发送请求

    sendRedirect方法远程控制浏览器请求行为【请求地址，请求方式，请求参数】
     */
}
