package com.bjpowernode.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;//servletRequest没有HttpSession，要强转到子类HttpServletRequest才有
        HttpSession session = null;
        //1.调用请求对象读取请求包中请求行中URI,了解用户访问的资源文件时谁
        String uri = request.getRequestURI();//【/网站名/资源文件名】
        //2.如果本次请求资源文件与登录相关【login.html或者LoginServlet】此时应该无条件放行
        if (uri.indexOf("login")!=-1 || "/myweb/".equals(uri)){//uri与indexOf返回值（）相等或默认返回与uri相等
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //3.如果本次请求访问的是其他资源文件，需要得到用户在服务端HttpSession
        session = request.getSession(false  );
        if (session!=null){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //4.做拒绝请求
        request.getRequestDispatcher("/login_error.html").forward(servletRequest,servletResponse);
    }
}

//会将登录页面一起拦截

//    //1.拦截后通过请求对象向Tomcat索要当前用户的HttpSession
//    HttpSession session = request.getSession(false);
////2.判断来访用户身份合法性
//        if (session ==null){
//                request.getRequestDispatcher("/login_error.html").forward(servletRequest,servletResponse);
//                return;
//                }
//                //3.放行
//                filterChain.doFilter(servletRequest,servletResponse);