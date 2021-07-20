package com.bjpowernode.filter;

import javax.servlet.*;
import java.io.IOException;

public class OneFilter implements Filter {
    //通知拦截的请求对象，使用utf-8字符集对当前的请求体信息进行一次重新编辑
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");   //增强
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
