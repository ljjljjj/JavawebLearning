package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao dao = new UserDao();
        PrintWriter out;
        //1.【调用DAO】将查询命令推送到数据库服务器上，得到所有的用户信息【List】
        List<Users> userList = dao.findAll();                           //加泛型，方便循环遍历输出
        //2.【调用响应对象】将用户信息结合<table>标签命令以二进制形式写入到响应体
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        out.print("<table border = '2' align= 'center'>");
        out.print("<tr>");
        out.print("<td>用户编号</td>");
        out.print("<td>用户姓名</td>");
        out.print("<td>用户密码</td>");
        out.print("<td>用户性别</td>");
        out.print("<td>用户邮箱</td>");
        out.print("<td>删除操作</td>");


        out.print("</tr>");
        for (Users users : userList) {                                   //循环遍历输出
            out.print("<tr>");
            out.print("<td>" + users.getUserId() + "</td>");
            out.print("<td>" + users.getUserName() + "</td>");
            out.print("<td>******</td>");
            out.print("<td>" + users.getSex() + "</td>");
            out.print("<td>" + users.getEmail() + "</td>");
            out.print("<td><a href='/myweb/user/delete?userId="+users.getUserId()+"'>删除用户</a></td>");//注意格式
            //out.print("<td><a href='/myweb/user/update?userId="+users.getUserId()+"'>更新用户</a></td>");//注意格式


            out.print("</tr>");
        }
        out.print("</table>");
    }

}
