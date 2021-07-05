package com.bjpowernode.test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class 预编译实现批处理 {
    public static void main(String[] args) throws Exception{
        //预编译形式的sql命令
        //"?"是占位符，一个问号代替一个值
        //预编译sql相当于一个模具，在后续开发时，只需要将数据填充到占位符，就可以得到一个全新sql
        String sql = "insert into dept_copy(deptno,dname,loc) values(?,?,?)";
                                                            //?serverTimezone=GMT%2B8&useSSL=false
        String url ="jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=GMT%2B8&useSSL=false";
        //1.注册Driver
        Class.forName("com.mysql.jdbc.Driver");
        //2.建立通道
        Connection con = DriverManager.getConnection(url,"root","123456");
        //3.建立交通工具[需要将预编译sql命令注册到PreparedStatement]
        PreparedStatement ps = con.prepareStatement(sql);
        //4.向MySQL服务器推送100条数据
        for(int i=1;i<=100;i++){
            //通过预编译sql命令填充数据生成全新的sql命令
            ps.setInt(1,i);//insert into dept_copy(deptno,dname,loc) values(1,?,?)
            ps.setString(2,"dept_"+i);//insert into dept_copy(deptno,dname,loc) values(1,'dept_1',?)
            ps.setString(3,"广州");//insert into dept_copy(deptno,dname,loc) values(1,'dept_1','北京')

            //在新的sql语句生成后，将sql语句作为子弹添加到ps的弹夹中
            ps.addBatch();//[sql1,sql2,sql...]

            //5.[一次性]通过ps将100条sql语句推送到MySQL服务器执行
            ps.executeBatch();//推送100条sql命令只需要往返一次


        }
        //6.销毁资源
        if(ps!=null){
            ps.close();
        }
        if(con!=null){
            con.close();
        }
    }
}
