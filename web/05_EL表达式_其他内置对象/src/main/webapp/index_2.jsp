
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--{paramValues.请求参数名【下标】}-->
<!--
    http://localhost:8080/myweb/index_2.jsp?deptNo=10&deptNo=20&deptNo=30
-->

第一个部门编号：${paramValues.deptNo[0]}<br>
第二个部门编号：${paramValues.deptNo[1]}<br>
第三个部门编号：${paramValues.deptNo[2]}<br>