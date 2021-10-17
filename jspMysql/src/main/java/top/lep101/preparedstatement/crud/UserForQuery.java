package top.lep101.preparedstatement.crud;

import org.junit.Test;
import top.lep101.bean.User;
import top.lep101.util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/*
* @Description 针对于User表的查询操作
* */
public class UserForQuery {
    /*
    *
    * 针对于表的字段名与类的属性名不相同的情况:
    * 1.必须声明sql时,使用类的属性名来命名字段的别名
    * 2.使用ResultSetMetaData时,需要使用getColumnLabel()来替换getColumnName(),获取列的列名
    *   说明:如果sql中没有给字段取别名:getColumnLabel()获取的就是别名
    *
    * */
    @Test
    public void testQueryForUser(){
        String sql = "select username,password from user where username = ?";
        User user = queryForUser(sql, "lwp");
        System.out.println(user);
    }

    /*
    * @Description 针对user表的通用的查询操作
    * */
    public User queryForUser(String sql,Object...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i ++){
                ps.setObject(i+1,args[i]);
            }

            rs = ps.executeQuery();
            //获取结果集的元数据 String name = "Tom";
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            if (rs.next()){
                User user = new User();
                //处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++){
                    //获取列值
                    Object columnValue = rs.getObject(i + 1);

                    //获取每个列的列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //获取列的列名:getColumnName() --不推荐使用
                    //获取列的别名:getColumnLabel()
                    //给user对象指定的某个属性,赋值为columnValue，通过反射
                    Field field = User.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(user,columnValue);
                }
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }

        return null;
    }

    @Test
    public void testQuery1(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select username,password from user where username = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,"lep101");

            //执行,并返回结果集
            resultSet = ps.executeQuery();
            //处理结果集
            if (resultSet.next()){//next():判断结果集的下一条是否有数据,如果有数据返回true,并指针下移,如果返回false,指针不会下移。

                //获取当前这条数据的各个字段值
                String username = resultSet.getString(1);
                String password = resultSet.getString(2);

                //方式一:
    //            System.out.println("username=" + username + "password= " + password);
                //方式二:
    //            Object[] data = new Object[]{username,password};
                //方式三:将数据封装为一个对象(推荐)
                User user = new User(username, password);
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            JDBCUtils.closeResource(conn,ps,resultSet);
        }
    }

}
