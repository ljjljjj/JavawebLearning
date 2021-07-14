package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 抽象类作用：   降低接口实现类对接口实现过程难度
 *              将接口中不需要使用抽象方法教给抽象类进行完成
 *              这样接口实现类只需要对接口需要方法进行重写
 *
 * Tomcat根据Servlet规范调用Servlet接口实现类规则：
 *              1.Tomcat有权创建Servlet接口实现类实例对象
 *              Servlet oneServlet = new OneServlet90;
 *              2.Tomcat根据实例对象调用service方法处理当前请求
 *              oneServlet.service()，此时service方法中this=====oneServlet
 */
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServlet类针对浏览器发送GET请求方式进行处理");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServlet类针对浏览器发送POST请求方式进行处理");
    }
}
