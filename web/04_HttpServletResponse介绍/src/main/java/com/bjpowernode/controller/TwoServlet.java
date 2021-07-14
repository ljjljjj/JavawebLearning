package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 问题描述：浏览器收到的数据是2，不是50
 *  问题原因：
 *          out.writer方法可以将【字符】，【字符串】，【ASCII码】写入到响应体
 *          【ASCII码】： a---------97
 *                      2---------50
 * 问题解决方案：实际开发过程中，都是通过out.print()将真实数据写入到响应体
 */
public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int money = 50;
        PrintWriter out = response.getWriter();
        //out.write(money);
        out.print(money);
    }

}
