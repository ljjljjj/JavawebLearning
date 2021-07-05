package com.bjpowernode.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class 推送查询命令 {
    public static void main(String[] args) throws Exception{
        //url
        String url = "jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=GMT%2B8&useSSL=false";
        //sql
        String sql = "select * from dept";

        //Driver注册
        Class.forName("com.mysql.jdbc.Driver");
        //2.建立通道
        Connection con = DriverManager.getConnection(url,"root","123456");
        //3.建立交通工具
        PreparedStatement ps = con.prepareStatement("");
        //4.推送命令得到处理结果
        ResultSet rs = ps.executeQuery(sql);

        //5.通过ResultSet对象将临时表所有数据行读取出来
        while(rs.next()){
            int deptNo = rs.getInt("deptNo");
            String dname = rs.getString("dName");
            String loc = rs.getString("loc");
            System.out.println("部门编号：" + deptNo + "部门名称：" + dname + "部门位置：" + loc);
        }
        //6.销毁资源,有顺序，临时表->交通工具：ps->通道：con
        if(rs!=null){
            rs.close();
        }
        if(ps!=null){
            ps.close();
        }
        if(con!=null){
            con.close();
        }

    }
}
