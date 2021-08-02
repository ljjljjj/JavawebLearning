<%@ page import="com.bjpowernode.entity.Users" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: luo
  Date: 2021/7/29
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border='2' align='center'>
    <tr>
        <td>用户编号</td>
        <td>用户姓名</td>
        <td>用户密码</td>
        <td>用户性别</td>
        <td>用户邮箱</td>
        <td>删除操作</td>
        <td>更新操作</td>
    </tr>
    <%
        List<Users> usersList = (List)request.getAttribute("key1");
        for (Users users : usersList) {
    %>
    <tr>
        <td><%=users.getUserId()%>
        </td>
        <td><%=users.getUserName()%>
        </td>
        <td><%=users.getPassword()%>
        </td>
        <td><%=users.getSex()%>
        </td>
        <td><%=users.getEmail()%>
        </td>
        <td>
            <a href="/myweb/user/delete?userId=<%=users.getUserId()%>">删除用户</a>
        </td>
        <td>
            <a href="/myweb/user/findById?userId=<%=users.getUserId()%>">更新用户</a>
        </td>
<%
    }
%>

    </tr>

</table>
</body>
</html>
