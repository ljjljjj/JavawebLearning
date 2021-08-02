<% Users users = null; %><%--
  Created by IntelliJ IDEA.
  User: luo
  Date: 2021/7/29
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.bjpowernode.entity.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <form action="/myweb/user/update" method="get">
        <table border="2" align="center">
            <tr>
                <td>用户编号</td>
                <td><input type="text" name="userId"
                           value="${requestScope.key1.userId}" readonly></td>
            </tr>
            <tr>
                <td>用户名称</td>
                <td><input type="text" name="userName"
                           value="${requestScope.key1.userName}"></td>
            </tr>
            <tr>
                <td>用户密码</td>
                <td><input type="password" name="password"
                           value="${requestScope.key1.password}"></td>
            </tr>
            <tr>
                <td>用户性别</td>
                <td>
                    <input type="radio" name="sex"
                           value="男" ${"男" eq key1.sex?"Checked":""}>男
                    <input type="radio" name="sex"
                           value="女" ${"女" eq key1.sex?"Checked":""}>女
                </td>
            </tr>
            <tr>
                <td>用户邮箱</td>
                <td><input type="text" name="email"
                           value="${requestScope.key1.email}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="更新信息"></td>
                <td><input type="reset"></td>
            </tr>

        </table>
    </form>

</body>
</html>
