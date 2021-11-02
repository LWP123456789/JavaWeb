<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/2
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8090/Model2/bookServlet" method="get">
        <table>
            <tr>
                <td><span>书的编码: </span></td><td><input type="number" name="bookId" placeholder="请输入书的ISBN编码"></td>
            </tr>
            <tr>
                <td><span>书名：</span></td><td><input type="text" name="bookName" placeholder="请输入书名"></td>
            </tr>
            <tr><td colspan="2"><input type="submit" value="提交查询"></td><td></td></tr>
        </table>
    </form>
</body>
</html>
