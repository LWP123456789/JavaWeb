<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/18
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Object username = application.getAttribute("username");
        if (username == null)
        {
            %>
            <jsp:forward page="index.jsp"></jsp:forward>
            <%
        }
    %>
</body>
</html>
