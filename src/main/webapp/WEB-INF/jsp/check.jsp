<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/8
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>用户登录</title>
</head>
<body>
    <%
        if (request.getParameter("username").equals("lep")&&request.getParameter("pwd").equals(123456))
        {
    %>
        <jsp:forward page="success.jsp">
            <jsp:param name="aa" value="bb"/>
            <jsp:param name="aa11" value="bb11"/>
        </jsp:forward>
    <%
        }
        else
    %>
    <%-- 表达式遇到js就停止 --%>
    <script>alert("用户名或密码错误!")</script>
</body>
</html>
