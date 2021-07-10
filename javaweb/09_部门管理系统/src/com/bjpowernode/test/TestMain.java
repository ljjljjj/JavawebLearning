package com.bjpowernode.test;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * 1.添加部门
 * 2.查询部门
 * 3.删除部门
 * 4.更新部门
 */
public class TestMain {
    public static void main(String[] args)throws Exception {
        //读取用户再控制台输入的请求
        Scanner request = new Scanner(System.in);
        int flag  = 0;
        //sql命令
        String sql_1="insert into dept(deptno,dname,loc) values(?,?,?)";
        String sql_2="select * from dept";
        String sql_3="delete from dept where deptno=?";
        String sql_4="update dept set dname=?,loc=? where deptno=?";
        String sql_5="select count(*) from emp where ename=? and empno=?";

        //声明变量

        String deptno,dname,loc,ename,password;
        //注册driver
        Class.forName("com.mysql.jdbc.Driver");
        //建立通道
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=GMT%2B8&useSSL=false","root","123456"  );
        //交通工具
        PreparedStatement ps =null;

        //登录验证
        System.out.println("*******请输入用户名*******");
        ename = request.next();
        System.out.println("*******请输入密码*******");
        password = request.next();
        ps = con.prepareStatement(sql_5);
        ps.setString(1,ename);
        ps.setInt(2,Integer.valueOf(password));
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            flag = rs.getInt("count(*)");
        }
        if (rs!=null){
            rs.close();
        }
        if (ps!=null){
            ps.close();
        }
        if (flag !=1){
            System.out.println("登录失败，请重启程序");
            return;
        }

        while (true){
            //导航
            System.out.println("*********欢迎使用部门管理系统**********");
            System.out.println("*******1.添加部门*******");
            System.out.println("*******2.查询部门*******");
            System.out.println("*******3.删除部门*******");
            System.out.println("*******4.更新部门*******");
            System.out.println("*******请输入操作*******");
            //获取用户请求
            flag =request.nextInt();

            if (flag ==1){
                System.out.println("*******请输入部门编号*******");
                deptno = request.next();
                System.out.println("*******请输入部门名称*******");
                dname = request.next();
                System.out.println("*******请输入部门位置*******");
                loc = request.next();
                //推送sql命令
                ps = con.prepareStatement(sql_1);

                ps.setInt(1,Integer.valueOf(deptno));
                ps.setString(2,dname);
                ps.setString(3,loc);
                //判断输入的数据行数
                flag = ps.executeUpdate();
                //判断数据是否输入成功
                if (flag ==1){
                    System.out.println("部门添加成功！！！");
                }else{
                    System.out.println("部门添加失败！！！");
                }
            }else if (flag ==2){

                ps= con.prepareStatement(sql_2);
                rs = ps.executeQuery();
                while (rs.next()){
                    deptno = rs.getString("deptno");
                    dname = rs.getString("dname");
                    loc = rs.getString("loc");
                    System.out.println("部门编号："+ deptno+ "   部门名称："+ dname+"     部门位置："+loc);
                }
                if (rs!=null){
                    rs.close();
                }
                if (ps!=null){
                    ps.close();
                }
            }else if (flag ==3){
                System.out.println("*******请输入部门编号*******");
                deptno = request.next();
                ps = con.prepareStatement(sql_3);
                ps.setInt(1,Integer.valueOf(deptno));
                flag = ps.executeUpdate();

                if (ps!=null){
                    ps.close();
                }
                if (flag==1){
                    System.out.println("部门删除成功！！！");
                }else{
                    System.out.println("部门删除失败！！！");
                }
            }else{
                System.out.println("*******请输入部门编号*******");
                deptno = request.next();
                System.out.println("*******请输入部门名称*******");
                dname = request.next();
                System.out.println("*******请输入部门位置*******");
                loc = request.next();

                ps = con.prepareStatement(sql_4);
                ps.setString(1,dname);
                ps.setString(2,loc);
                ps.setInt(3,Integer.valueOf(deptno));
                flag = ps.executeUpdate();
                if (ps!=null){
                    ps.close();
                }
                if (flag==1){
                    System.out.println("部门更新成功！！！");
                }else{
                    System.out.println("部门更新失败！！！");
                }
            }
            System.out.println("返回上一级菜单请按任意键，退出系统请按0");
            flag = request.nextInt();
            if (flag==0){
                System.out.println("系统正在关闭中！！！");
                if (con!=null){
                    con.close();
                }
                System.out.println("谢谢使用，系统已关闭");
                break;
            }
        }

    }
}
