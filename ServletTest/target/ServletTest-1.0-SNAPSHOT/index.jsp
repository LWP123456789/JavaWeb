<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="http://localhost:8080/ServletTest/helloServlet" method="get">
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