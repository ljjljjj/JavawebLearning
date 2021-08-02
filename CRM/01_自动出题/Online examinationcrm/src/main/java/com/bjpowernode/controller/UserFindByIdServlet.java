package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.dao.UserDao;
import com.bjpowernode.entity.Question;
import com.bjpowernode.entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UserFindByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId;
        UserDao dao = new UserDao();
        Users  users = null;
        //1.调用请求对象读取请求头中参数信息，得到学生编号
        userId = request.getParameter("userId");
        //2.调用Dao推送查询命令得到这个学生编号对应的学生信息
        users = dao.findById(userId);
        //3.调用user_update.jsp 将学生信息写入到响应体
        request.setAttribute("key1", users);
        request.getRequestDispatcher("/user_update.jsp").forward(request, response);


    }
}
