<%@ page import="jakarta.websocket.Session" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/13
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
</head>
<body>
    <span id="welcome">欢迎,<%=session.getAttribute("userSession")%></span>
</body>
</html>
