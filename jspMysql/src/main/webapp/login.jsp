<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/17
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="login_failure.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login_check.jsp" method="get">
    <table>
        <tr>
            <td><span>用户: </span></td><td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td><span>密码：</span></td><td><input type="password" name="password"></td>
        </tr>
        <tr><td colspan="2"><input type="submit" value="提交查询"></td><td></td></tr>
    </table>
</form>
</body>
</html>
