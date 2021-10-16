package top.lep101.bean;

/*
* ORM编程思想 (object relational mapping)
* 一个数据表对应一个java类
* 表中的一条记录对应java类的一个对象
* 表中的一个字段对应java类的一个属性
* */
public class User {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
