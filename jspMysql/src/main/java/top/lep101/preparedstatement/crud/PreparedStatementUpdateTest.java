package top.lep101.preparedstatement.crud;

/*
* 使用PreparedStatement来替换Statement,实现对数据表的增删改操作
*
* 增删改
*
*
* */

import org.junit.Test;
import top.lep101.util.JDBCUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class PreparedStatementUpdateTest {

    @Test
    public void testCommonUpdate(){
        //删除操作
        /*
            String sql = "delete from user where username = ?";
            update(sql,"test");
        * */

        //修改操作
        String sql = "update user set password = ? where username = ?";
        update(sql,"luoweipeidage","weiyuexin");
    }

    //通用的增删改操作
    public void update(String sql,Object ...args) {//sql中占位符的个数与可变形参的长度一致
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句,返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0;i < args.length; i++){
                ps.setObject(i+1,args[i]);
            }
            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5.资源的关闭
            JDBCUtils.closeResource(conn,ps);
        }
    }

    //修改表的一条记录
    @Test
    public void testUpdate(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句,返回PreparedStatement的实例
            String sql = "update user set username = ? where password = ?";
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            ps.setString(1,"LuoWeiPei");
            ps.setObject(2,"php123456");
            //4.执行sql
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5.资源的关闭
            JDBCUtils.closeResource(conn,ps);
        }
    }

    @Test
    public void TestConnection(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1、读取配置文件中的信息
            InputStream is=PreparedStatementUpdateTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

            Properties pros=new Properties();
            pros.load(is);

            String user=pros.getProperty("user");
            String password=pros.getProperty("password");
            String url=pros.getProperty("url");
            String driverClass=pros.getProperty("driverClass");

            //2、加载驱动
            Class.forName(driverClass);

            //3、获取链接
            conn = DriverManager.getConnection(url,user,password);

            //4、预编译sql语句,返回PreparedStatement的实例
            String sql = "insert into user(username,password)values(?,?)";//?是占位符
            ps = conn.prepareStatement(sql);

            //5、填充占位符
            ps.setString(1,"lep101");
            ps.setString(2,"Golang123456");

            //6、执行操作
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7、资源的关闭
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
    }
}
