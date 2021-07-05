package com.bjpowernode.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 1.sql命令书写麻烦：
 *      为了确保每条失去了语句携带不同数据，采用字符串拼接方式
 *      "insert into dept_copy(deptno,dname,loc) values("+i+",'dept_"+i+"','广州')"
 * 2.浪费时间：
 *      PreparedStatement对象每次只能推送一条sql命令。
 *      为了推送100条sql命令，需要往返100次，浪费了大量时间
 */

public class 原始批处理添加 {
    //throw 与 throws 的区别
    public static void main(String[] args)throws Exception {
        String url ="jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=GMT%2B8&useSSL=false";

        //1.注册
        Class.forName("com.mysql.jdbc.Driver");
        //2.建立通道
        Connection con = DriverManager.getConnection(url,"root","123456");
        //3.建立使用Connection建立交通工具
        PreparedStatement ps = con.prepareStatement("");
        //4.向MySQL服务器推入100条数据进行插入
        for(int i=1;i<=100;i++){
            String sql="insert into dept_copy(deptno,dname,loc) values("+i+",'dept_"+i+"','广州')";
            ps.executeUpdate(sql);
        }

            //5.销毁资源
            if(ps!=null){
                ps.close();
            }
            if(con!=null) {
                con.close();
            }
    }
}
