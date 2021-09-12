<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>

<%--
<base> 标签设置页面相对路径工作时参照的地址
    href 属性就是参数的地址值
--%>

<%--
    在 javaWeb 中，路径分为相对路径和绝对路径两种：
        相对路径是： . 表示当前目录 .. 表示上一级目录 资源名 表示当前目录/资源名
        绝对路径： http://ip:port/工程路径/资源路径 在实际开发中，路径都使用绝对路径，而不简单的使用相对路径。 1、绝对路径 2、base+相对

    在 web 中 / 斜杠 是一种绝对路径。
        / 斜杠 如果被浏览器解析，得到的地址是：http://ip:port/ <a href="/">斜杠</a>
        / 斜杠 如果被服务器解析，得到的地址是：http://ip:port/工程路径 1、<url-pattern>/servlet1</url-pattern> 2、servletContext.getRealPath(“/”); 3、request.getRequestDispatcher(“/”); 特殊情况： response.sendRediect(“/”); 把斜杠发送给浏览器解析。得到 http://ip:port/
--%>