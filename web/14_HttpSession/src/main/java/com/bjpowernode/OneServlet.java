package com.bjpowernode;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void      doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsName;
        //1.调用请求对象，读取请求头参数，得到用户选择商品名
        goodsName =request.getParameter("goodsName");

        //2.调用请求对象，向Tomcat服务器索要当前用户在服务端的私人储物柜HttpSession
        HttpSession session = request.getSession();
        //request.getSession(false    );//也可以用来申请私人储物柜，1.在本来就拥有储物柜才可成功申请，2.在原本无储物柜时，不会申请新的储物柜，返回null
        //3.将用户选购的商品添加到当前用户私人储物柜
        Integer goodsNum = (Integer) session.getAttribute(goodsName);
        if (goodsNum==null){
            session.setAttribute(goodsName,1);
        }else{
            session.setAttribute(goodsName,goodsNum+1);
        }
    }

}
