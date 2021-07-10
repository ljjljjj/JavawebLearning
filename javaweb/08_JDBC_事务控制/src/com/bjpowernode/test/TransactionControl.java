package com.bjpowernode.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 需求：
 *      删除部门30以及部门下的职员信息
 * sql：
 *      delete from dept where deptno=30;
 *      delete from emp  where deptno=30;
 *
 * 规则：
 *      在一个需求中，只要有一个sql语句无法执行的
 *      此时所有sql语句都判定无效
 */
public class TransactionControl {
    public static void main(String[] args) throws Exception{
        String sql_1="delete from dept_copy where deptno=30;";
        String sql_2="delete from dept_copy where deptno=20;";

        String url ="jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=GMT%2B8&useSSL=false";
        //1.注册driver
        Class.forName("com.mysql.jdbc.Driver");

        //2.建立通道
        Connection con = DriverManager.getConnection(url,"root","123456");
        //3.通过连接通道向MySQL服务器发送命令"start transaction"
        con.setAutoCommit(false);
        //4.建立交通工具
        PreparedStatement ps = con.prepareStatement("");
        //5.推送sql命令
        try{
            ps.executeUpdate(sql_1);
            ps.executeUpdate(sql_2);
            con.commit();
        }catch (SQLException ex){
            con.rollback();//出现SQL Exception则通知MySQL服务器，使用备份覆盖表文件，取消本次操作
        }finally {
            if(ps!=null){
                ps.close();
            }
            if (con!=null){
                con.close();
            }
        }
    }
}
/**
 * 本次测试不小心导错包了
 * 出现错误，是因为包的版本比jdk版本低
 */