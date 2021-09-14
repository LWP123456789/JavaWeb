<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/14
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>校验页面</title>
</head>
<body>
    <%
        // 从表单中获取提交的用户名密码
        String username = request.getParameter("user");
        String password = request.getParameter("pwd");
        System.out.println(username);
        System.out.println(password);
        // 验证用户名和密码是否为空
        if(username.equals("") || password.equals("")){
            out.print("<script type='text/javascript'>alert('用户名或密码不能为空!');history.back(-1);</script>");
        }else {
            if (password.equals("123456")){
                // 将用户信息加入session
                session.setAttribute("userSession",username);
                // 跳转到主页面
                response.sendRedirect("welcome.jsp");
            }else {
                out.print("<script type='text/javascript'>alert('密码不正确!');history.back(-1);</script>");
            }
        }
        // history 对象
        /*
         *   .back(-1)直接返回当前页的上一页，数据全部消失,是个新页面
         *   .go(-1)  也是返回当前页的上一页，不过表单里的数据全部还在
         *   .back(0) 刷新
         * */
    %>

</body>
</html>
