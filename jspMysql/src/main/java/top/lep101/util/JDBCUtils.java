package top.lep101.util;

import top.lep101.preparedstatement.crud.PreparedStatementUpdateTest;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/*
* @Description 操作数据库的工具类
* @author lwp Email:LWP13226968149@163.com
* @version
* @data  2021.10.16
* */
public class JDBCUtils {

    /*
    * @Description 获取数据库的拦截
    * */
    public static Connection getConnection() throws Exception {
        //1、读取配置文件中的信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros=new Properties();
        pros.load(is);

        String user=pros.getProperty("user");
        String password=pros.getProperty("password");
        String url=pros.getProperty("url");
        String driverClass=pros.getProperty("driverClass");

        //2、加载驱动
        Class.forName(driverClass);

        //3、获取链接
        Connection conn = DriverManager.getConnection(url,user,password);
        return conn;
    }
    /*
    * @Description 关闭连接和Statement
    * */
    public static void closeResource(Connection conn, Statement ps){
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
    }
    //关闭资源操作
    public static void closeResource(Connection conn, Statement ps,ResultSet rs){
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
    }
}
