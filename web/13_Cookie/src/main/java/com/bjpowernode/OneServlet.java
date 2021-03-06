package com.bjpowernode;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,money;
        //1.调用请求对象读取【请求头】参数信息
        userName = request.getParameter("userName");
        money = request.getParameter("money");
        //2.开卡
        Cookie card1 = new Cookie("userName",userName);
        Cookie card2 = new Cookie("money",money);

        //3.指定card2在客户端硬盘上存活1分钟
        card2.setMaxAge(60);


        //3.发卡，将Cookie写入到响应头交给浏览器
        response.addCookie(card1);
        response.addCookie(card2);
        //4.通知Tomcat将【点餐页面】内容写入到响应体交给浏览器(请求转发)
        request.getRequestDispatcher("/index_2.html").forward(request,response);

    }

}
