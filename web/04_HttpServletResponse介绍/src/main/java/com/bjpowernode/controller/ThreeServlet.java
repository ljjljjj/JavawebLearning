package com.bjpowernode.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * 问题描述：java<br>mysql<br>html
 *          浏览器在接收到响应结果时，将<br>作为文字内容在窗口中展示
 *          没有将<br>当作HTML标签命令来执行
 *  问题原因：
 *          浏览器在接收到响应包之后，根据【响应头中content-type】
 *          属性的值，来采用对应【编译器】对【响应体中二进制内容】进行编译处理
 *          在默认情况下，content-type属性的值”text"content-type= "text"
 *          此时浏览器将会采用【文本编译器】对响应体二进制数据进行解析
 * 问题解决方案：
 *          一定要在得到输出流之前，通过响应对象响应头中content-type属性进行
 *          一次重新赋值用于指定浏览器采用正确编译器
 */
public class ThreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = "java<br>mysql<br>html<br>";
        String result2 = "红烧排骨<br>梅菜肘子<br>客家豆腐";
        //设置响应头content-type
        response.setContentType("text/html;charset=utf-8");
        //向tomcat索要输出流
        PrintWriter out = response.getWriter();
        //通过输出流将结果写入到响应体
        out.print(result);
        out.print(result2);
    }

}
