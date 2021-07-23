package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password;
        UserDao dao = new UserDao();
        int result = 0;
        //1.调用请求对象对请求体使用utf-8字符集进行重新编辑
        request.setCharacterEncoding("utf-8");
        //2.调用请求对象读取请求体参数信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        //3.调用Dao将查询验证信息推送到数据库服务器上
        result = dao.login(userName,password);
        //4.调用响应对象，根据验证结果将不同资源文件地址写入到响应头，交给浏览器
        if(result == 1){

            //在判定来访用户身份合法后，通过请求对象向Tomcat申请为当前用户申请一个HttpSession
            HttpSession session = request.getSession();

            response.sendRedirect("/myweb/index.html");
        }else{
            response.sendRedirect("/myweb/login_error.html");
        }
    }
}
