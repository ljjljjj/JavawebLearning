package com.bjpowernode.test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class 推送插入命令 {
    public static void main(String[] args) throws Exception {
        //产生异常向上抛   throws Exception

        //"jdbc:mysql://服务器所在计算机ip地址:服务器端口号/访问的数据库"
        String url = "jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=GMT%2B8&useSSL=false";
        //sql命令
        String sql = "insert into dept(deptno,dname,loc) values(60,'大额贷款部','上海'),(70,'银行融合部门','北京')";

        //1.将MySQL服务器提供的jar包的Driver接口实现类，注册到jvm中
        Driver driver =new com.mysql.jdbc.Driver();
        DriverManager.registerDriver(driver);
        //2.通过DriverManager在Java工程和MySQL服务器之间建立一个连接通道，con是管理通道的
        Connection con = DriverManager.getConnection(url,"root","123456");

        //3.在通道上创建一个交通工具
        PreparedStatement ps = con.prepareStatement("");

        //4.通过交通工具将sql命令推送到MySQL服务器上来执行，并带回处理结果
        int result = ps.executeUpdate(sql);

        //5.销毁相关资源
        if(ps!=null){
            ps.close();
        }
        if(con!=null){
            con.close();
        }
        System.out.println("本次交易中，在Dept表文件添加了"+ result + "行数据");

    }
}
