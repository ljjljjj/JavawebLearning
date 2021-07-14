package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.通过请求对象获得【请求头】中【所有请求参数名】
        Enumeration parameter = request.getParameterNames();
        while (parameter.hasMoreElements()){
            String paramName = (String) parameter.nextElement();

            //2.通过请求对象读取指定的请求参数的值
            String values = request.getParameter(paramName);
            System.out.println("请求参数名：  " + paramName+ "请求参数值：  "+ values);
        }
    }

}
