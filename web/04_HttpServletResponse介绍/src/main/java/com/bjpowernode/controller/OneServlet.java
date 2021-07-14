package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = "Hello world";

        //--------响应对象将结果写入到响应体中--------start

            //  1.通过响应对象，向Tomcat索要输出流
        PrintWriter out = response.getWriter();
            //  2.通过输出流，将执行结果以二进制形式写入到响应体
        out.write(result);

        //--------响应对象将结果写入到响应体中--------start
    }//doGet执行完毕
        //Tomcat将响应包推送给浏览器

}
