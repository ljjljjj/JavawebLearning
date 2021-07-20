package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map map = new HashMap();
        //int num = (int) map.get("key1");//抛出空指针异常NullPointerException
        System.out.println("ksdjaf;ladj");
        Integer num = (Integer) map.get("key1");
        //int a = null;//null值不可能赋值给int
        Integer b = null;//所有高级引用类型都可以赋值为null
    }
}
