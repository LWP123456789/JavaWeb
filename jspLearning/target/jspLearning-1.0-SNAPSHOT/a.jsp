<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/13
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<%--
errorPage表示错误后自动跳转去的路径 <br>
这个路径一般都是以斜杠打头，它表示请求地址为http://ip:port.工程路径/
映射到代码的web目录
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="welcome.jsp" method="get">
        <table>
            <tr>
                <td><span>用户: </span></td><td><input type="text"></td>
            </tr>
            <tr>
                <td><span>密码：</span></td><td><input type="password" name="pwd"></td>
            </tr>
            <tr><td colspan="2"><input type="submit" value="提交查询"></td><td></td></tr>
        </table>
    </form>
    <%--用户名: <input type="text"><br>
    密码: <input type="password" align="left">--%>
</body>
</html>
