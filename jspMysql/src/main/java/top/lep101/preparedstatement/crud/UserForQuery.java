package top.lep101.preparedstatement.crud;

import org.junit.Test;
import top.lep101.bean.User;
import top.lep101.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
* @Description 针对于User表的查询操作
* */
public class UserForQuery {

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
