<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/14
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言板</title>
</head>
<body>
    <%

        Vector v = (Vector) application.getAttribute("vector");
        System.out.println(v);

    %>

</body>
</html>
