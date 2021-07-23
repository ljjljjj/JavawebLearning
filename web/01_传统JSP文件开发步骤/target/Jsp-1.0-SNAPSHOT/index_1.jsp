<%--
  Created by IntelliJ IDEA.
  User: luo
  Date: 2021/7/22
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page
        contentType="text/html;charset=UTF-8"
        language="java" %>
<%
    Integer sid = (Integer) application.getAttribute("sid");
    String  sname = (String) session.getAttribute("sname");
    String  home  =(String) request.getAttribute("home");
%>
学生编号：<%=sid%><br>
学生姓名：<%=sname%><br>
学生住址：<%=home%>
<hr/>
<h1>EL表达式</h1>
${applicationScope.sid}<br>
${sessionScope.sname}<br>
${requestScope.home}