package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao dao = new UserDao();
        //1.调用DAO推送查询命令得到所有的学生
        List list = dao.findAll();
        //2.将得到试题添加到请求作用域对象作为共享数据
        request.setAttribute("key1",list);
        //3.请求转发向Tomcat调用user.jsp 将结果与html标签写入响应体
        request.getRequestDispatcher("/user.jsp").forward(request,response);
    }

}
