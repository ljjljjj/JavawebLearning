<%@ page import="java.util.List" %>
<%@ page import="com.bjpowernode.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: luo
  Date: 2021/7/21
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2" align="center">
    <tr align="center">
        <td>题目编号</td>
        <td>题目信息</td>
        <td>A</td>
        <td>B</td>
        <td>C</td>
        <td>D</td>
        <td>正确答案</td>
        <td colspan="2">操作</td>
    </tr>
    <%
        List<Question> questionList = (List)request.getAttribute("key"); 
    %>
    <tr>
        <td><%=question.getQuestionId()%></td>
        <td><%=question.getTitle()%></td>
        <td><%=question.getOptionA()%></td>
        <td><%=question.getOptionB()%></td>
        <td><%=question.getOptionC()%></td>
        <td><%=question.getOptionD()%></td>
        <td><%=question.getAnswer()%></td>
        <td>
            <a href="/myweb/question/delete?questionId=<%=question.getQuestionId()%>">删除试题</a>
        </td>
        <td>
            <a href="/myweb/question/findById?questionId=<%=question.getQuestionId()%>">详细信息</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
