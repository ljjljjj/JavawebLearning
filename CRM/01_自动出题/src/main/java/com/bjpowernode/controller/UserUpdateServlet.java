package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId,userName,password,sex,email;
        UserDao dao = new UserDao();
        Users users = null;
        int result = 0;
        //1.【调用请求对象】读取【请求头】参数信息，得到用户的信息
        userId = request.getParameter("userId");
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
        //2.【调用UserDao】将用户信息填充到insert命令并借助JDBC规范发送到数据库服务器
        users = new Users(Integer.valueOf(userId),userName,password,sex,email);
        result = dao.update(users);
        //3.【调用响应对象】将【处理结果】以二进制形式写入到响应体
        if (result == 1){
            request.setAttribute("info","用户信息更新成功");
        }else{
            request.setAttribute("info","用户信息更新失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }

    //Tomcat负责销毁【请求对象】和【响应对象】
    //Tomcat负责将Http响应协议包推送到发起请求的浏览器上
    //浏览器根据响应头content-type指定编译器对响应体二进制内容编译
    //浏览器将编译后结果在窗口中展示给用户【结束】
}













