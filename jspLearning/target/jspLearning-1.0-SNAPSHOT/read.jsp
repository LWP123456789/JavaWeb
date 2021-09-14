<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/14
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>读取生成页面</title>
</head>
<body>
    <%
        // 字符集
        request.setCharacterEncoding("UTF-8");
        // 获取用户名 ip 留言
        String username = request.getParameter("user");
        String ip = request.getRemoteAddr();
        String comment = request.getParameter("comment");

        String s = username + "@" + ip + "说：" + comment;
        Vector v = new Vector();
        v.add(s);

        application.setAttribute("vector",v);

        response.sendRedirect("liuyanban.jsp");
    %>
</body>
</html>
