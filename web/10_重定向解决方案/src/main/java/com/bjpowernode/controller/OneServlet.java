package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OneServlet  负责  洗韭菜");

        //重定向解决方案
        //response.sendRedirect("/myweb/two");//【地址格式：/网站名/资源文件名】
        //将其他网站资源文件地址发送给浏览器
        response.sendRedirect("http://www.baidu.com");//【地址格式：http://ip地址:端口号/网站名/资源文件名】
    }

}
