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
    <h1 align="center">留言板</h1>
    <h3 align="right">请文明发言</h3>
    <%
        Vector vr = new Vector();
        vr = (Vector) application.getAttribute("message");
        for (int i = 0; i < vr.size(); i++){
            String ss = (String) vr.get(i);
            out.print(ss+"<br/>");
        }
    %>
</body>
</html>
