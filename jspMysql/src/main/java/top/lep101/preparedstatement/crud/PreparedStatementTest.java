package top.lep101.preparedstatement.crud;

import org.junit.Test;
import top.lep101.bean.User;
import top.lep101.util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;


/*
* @Description PreparedStatement解决了Statement的拼串,sql问题,除此以外,还可以:
* 1.PreparedStatement操作Blob的数据,而Statement做不到.
* 2.PreparedStatement可以实现更高效的批量操作.
* */
public class PreparedStatementTest {

    @Test
    public void testLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入用户名: ");
        String user = scanner.nextLine();
        System.out.print("请输入密码: ");
        String password = scanner.nextLine();
        String sql = "SELECT username,password FROM user WHERE username = ? AND password = ?";
        User returnUser = getInstance(User.class,sql,user,password);
        if (returnUser != null) {
            System.out.println("登录成功");
        }else {
            System.out.println("用户名不存在或者密码错误");
        }
    }

    /*
     * @Description 针对于不同的表的通用的查询操作,返回表中的一条记录
     * */
    public <T> T getInstance(Class<T> clazz,String sql,Object...args){
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
                T t = clazz.newInstance();
                //处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++){
                    //获取列值
                    Object columnValue = rs.getObject(i + 1);

                    //获取每个列的列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //获取列的列名:getColumnName() --不推荐使用
                    //获取列的别名:getColumnLabel()
                    //给t对象指定的columnLabel属性,赋值为columnValue，通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }

        return null;
    }

}
