<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/18
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<jsp:include page="isLogin.jsp"></jsp:include>
<body>
    <center>
        <h1>登录操作</h1><hr>
        <h2>登录成功</h2>
        <h2>欢迎<font color="red"><%=request.getParameter("username")%></font>光临！</h2>
    </center>
</body>
</html>
