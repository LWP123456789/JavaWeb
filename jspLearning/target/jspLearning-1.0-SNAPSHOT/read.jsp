<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Vector" %>
<%@ page import="jakarta.servlet.ServletContext" %><%--
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
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String sdate = df.format(new Date());
%>
<%
    String username = request.getParameter("username");
    String ip = request.getRemoteAddr();
    String comment = request.getParameter("comment");
    String s = username + "@" + ip + "说：" + comment;
    add(s); // 调用
    System.out.println(s);
%>
<%!
    int i=1;
    Vector ve = new Vector();
    synchronized void add(String str)
    {
        ServletContext application = getServletContext();
        i++;
        ve.add(str);
        application.setAttribute("message",ve);
    }
%>
<a href="liuyanban.jsp">查看全部留言</a>
</body>
</html>
