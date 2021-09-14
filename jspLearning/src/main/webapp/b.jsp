<%@ page import="java.util.List" %>
<%@ page import="com.mysql.cj.protocol.Message" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/14
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言页面</title>
</head>
<body>
  <form action="read.jsp" method="get">
    <table>
      <tr>
        <td><span>用户: </span></td><td><input type="text" name="user"></td>
      </tr>
      <tr>
        <td><span>留言：</span></td><td><input type="text" name="comment"></td>
      </tr>
      <tr><td colspan="2"><input type="submit" value="提交"></td><td></td></tr>
    </table>
  </form>
  <form action="liuyanban.jsp" method="post">
    <input type="submit" value="查看全部留言" name="look">
  </form>
<%--  <%
    List<Message> list = (List<Message>) application.getAttribute("allMsgs");
    String username = request.getParameter("user");
    String ip = request.getRemoteAddr();
    String message = request.getParameter("comment");--%>

<%--/*    Message msg = new Message(username,ip,message);
      if (username!=null && ip!=null && message!=null) {
      if (list == null){
        list=new ArrayList<>();
        list.add(msg);
      }else {
        list.add(msg);
      }

      application.setAttribute("allMsgs",list);*/

    }
  %>--%>
</body>
</html>
