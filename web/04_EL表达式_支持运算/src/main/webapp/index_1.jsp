<%--
  Created by IntelliJ IDEA.
  User: luo
  Date: 2021/7/23
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--将作用域对象中共享数据读取出来相加，将相加结果写入到响应体-->
<%
    String num1 = (String) request.getAttribute("key1");
    Integer num2 = (Integer) request.getAttribute("key2");

    int sum = Integer.valueOf(num1) + num2;
%>
传统的Java运算结果:    <%=sum%><br>

EL表达式运算结果:  ${key1+key2}