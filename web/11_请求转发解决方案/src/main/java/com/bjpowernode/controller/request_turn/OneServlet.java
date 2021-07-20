package com.bjpowernode.controller.request_turn;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OneServlet  实施麻醉");
        //请求转发方案
        //1.通过当前请求对象生成资源文件申请报告
        RequestDispatcher report = request.getRequestDispatcher("/two");
        //2.将报告对象发送给Tomcat
        report.forward(request,response);
    }
}
