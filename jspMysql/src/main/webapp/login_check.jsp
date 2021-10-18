<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/17
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String username = request.getParameter("username") ;
        String password = request.getParameter("password") ;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lwp?serverTimezone=GMT", "root", "php123456");
            String sql = "select username,password from user where username = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setObject(2,password);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("验证成功!");
                flag = true;
                application.setAttribute("username",username);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5.资源的关闭
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("finished");
        }
    %>

    <%
        if (flag) {
    %>
    <jsp:forward page="login_success.jsp">
        <jsp:param name="username" value="<%=username%>"/>
    </jsp:forward>
    <%
    } else {
    %>
    <jsp:forward page="login_failure.jsp"/>
    <%
        }
    %>
</body>
</html>
