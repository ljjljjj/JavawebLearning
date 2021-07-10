package com.bjpowernode.util;

import java.sql.*;

/**
 * 将jdbc规范下的创建与销毁功能封装到方法
 *
 * 一、jdbc开发步骤：
 *      1.注册数据库服务器提供的Driver实现类
 *      2.创建一个连接通道交给connection接口的实例对象jdbc4Connection管理
 *      3.创建一个交通工具交给preparedStatement接口的实例对象jdbc4PreparedStatement管理
 *      4.通过交通工具在Java工程与数据库服务器之间进行传输，推送sql命令并返回执行结果
 *      5.交易结束后，销毁相关资源【ResultSet、PreparedStatement、Connection】
 */
public class JdbcUtil {

    private Connection con = null;                  //类文件属性，可以在类文件中所有方法使用
    private PreparedStatement ps = null;
    //在当前类文件第一次被加载到JVM中，JVM会字动调用当前类文件静态语句块
    static{
        //1.注册数据库服务器提供的Driver实现类
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Driver实现类接口被注册了");
    }

    //封装Connection对象创建细节
    public Connection createCon(){

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=GMT%2B8&useSSL=false","root","123456");
        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println("Connection对象创建失败");
        }
        return con;
    }

    //封装PreparedStatement对象创建细节
    public PreparedStatement createps(String sql){

        Connection con = createCon();

        try {
            ps = con.prepareStatement(sql);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return ps;
    }

    //封装PreparedStatement对象和Connection对象的销毁细节
    public void close(){
        if (ps!=null) {
            try {
                ps.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        if (con!=null){
            try {
                con.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
    //封装PreparedStatement对象和Connection对象以及ResultSet对象的销毁细节
    public void close(ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        close();
    }
}
