package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.dao.UserDao;
import com.bjpowernode.entity.Question;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserUpdateServlet extends HttpServlet {
    private List<Users> list;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId,userName,password,sex,email;
        UserDao dao = new UserDao();
        Users users = null;
        int result = 0;
        //1.调用请求对象读取请求头参数信息
        userId = request.getParameter("userId");
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
        //2.调用Dao实现更新操作
        users = new Users(Integer.valueOf(userId),userName,password,sex,email);
        result = dao.update(users);
        //3.调用info.jsp将操作结果写入到响应体
        if (result == 1 ){
            request.setAttribute("info","学生信息更新成功");
        }else{
            request.setAttribute("info","学生信息更新失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }

    //Tomcat负责销毁【请求对象】和【响应对象】
    //Tomcat负责将Http响应协议包推送到发起请求的浏览器上
    //浏览器根据响应头content-type指定编译器对响应体二进制内容编译
    //浏览器将编译后结果在窗口中展示给用户【结束】
}













