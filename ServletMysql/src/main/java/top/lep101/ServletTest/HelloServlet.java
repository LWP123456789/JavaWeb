package top.lep101.ServletTest;

import top.lep101.util.JDBCUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 *@Description 该Servlet类用于处理登录页面用户名和密码在Mysql中的校验
 */
public class HelloServlet extends HttpServlet {
    //定义好Connection、PreparedStatement、ResultSet
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    boolean flag = false;

    //处理Get请求的逻辑业务(查询操作)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取前端的用户名和密码，用于校验
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("初始化完毕");
        //JDBC连接数据库，获取连接，sql语句，查询
        //获取连接
        try {
            conn = JDBCUtils.getConnection();
            //定义sql语句
            String sql = "select username,password from user where username = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setObject(2,password);
            rs = ps.executeQuery();
            if (rs.next()){
                System.out.println("验证成功!");
                flag = true;
                //获取 ServletContext 对象  在jsp页面中可以通过application对象获取
                ServletContext context = getServletConfig().getServletContext();
                context.setAttribute("username",username);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }

        //判断是否验证成功，并实现跳转
        if (flag){
            flag = false;
            response.sendRedirect("/ServletMysql/login_success.jsp");
        }else {
            response.sendRedirect("/ServletMysql/login_failure.jsp");
        }
    }

}