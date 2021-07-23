<%@ page import="com.bjpowernode.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: luo
  Date: 2021/7/22
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 传统写法-->
<%
    Student student = (Student) request.getAttribute("key");
%>
学员编号：<%=student.getSid()%><br>
学员姓名：<%=student.getSname()%>

<hr/>
<!--sid来自于Student类属性名，大小写完全一致-->
学生编号：${requestScope.key.sid}<br>
学生姓名：${requestScope.key.sname}