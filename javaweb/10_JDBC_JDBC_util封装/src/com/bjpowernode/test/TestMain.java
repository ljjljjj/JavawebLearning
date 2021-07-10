package com.bjpowernode.test;

import com.bjpowernode.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args)throws Exception {
        JdbcUtil util = new JdbcUtil();             //调用工具，创建通道、交通工具、
        PreparedStatement ps = null;                //声明交通工具
        Scanner request = new Scanner(System.in);   //生成一个扫描对象，读取控制台输入的信息
        ResultSet rs = null;                        //生成临时表管理对象
        String username,password,dname,deptno,loc;
        int flag = 0;
        String sql_1 = "select count(*) from emp where ename=? and empno=?";
        String sql_2 = "insert into dept(deptno,dname,loc) values(?,?,?)";
        String sql_3 = "select * from dept";
        String sql_4 = "delete from dept where deptno=?";
        String sql_5 = "update dept set dname=?,loc=? where deptno=?";
        //登录验证start
        System.out.println("请输入用户名：");
        username = request.next();
        System.out.println("请输入密码：");
        password = request.next();
        ps = util.createps(sql_1);
        ps.setString(1,username);
        ps.setString(2,password);
        rs = ps.executeQuery();                     //推送结果
        while (rs.next()){
            flag = rs.getInt("count(*)");
        }
        util.close();                               //调用工具类，销毁资源
        if (flag!=1){
            System.out.println("输入信息不存在，请重新登录！");
            return;
        }
        //登录验证end
        while (true){
        //具体功能页面-start
        System.out.println("*********欢迎使用部门管理系统**********");
        System.out.println("*******1.添加部门*******");
        System.out.println("*******2.查询部门*******");
        System.out.println("*******3.删除部门*******");
        System.out.println("*******4.更新部门*******");
        System.out.println("*******请输入操作*******");
        flag = request.nextInt();


            if (flag == 1) {
                //添加操作
                System.out.println("*******请输入部门编号*******");
                deptno = request.next();
                System.out.println("*******请输入部门名称*******");
                dname = request.next();
                System.out.println("*******请输入部门位置*******");
                loc = request.next();
                //推送sql命令
                ps = util.createps(sql_2);

                ps.setInt(1, Integer.valueOf(deptno));
                ps.setString(2, dname);
                ps.setString(3, loc);
                flag = ps.executeUpdate();
                if (flag == 1) {
                    System.out.println("部门添加成功");
                } else {
                    System.out.println("部门添加失败");
                }
                util.close();
            } else if (flag == 2) {
                //查询操作
                ps = util.createps(sql_3);
                rs = ps.executeQuery();                         //从数据库获取数据
                while (rs.next()) {
                    deptno = rs.getString("deptno");
                    dname = rs.getString("dname");
                    loc = rs.getString("loc");
                    System.out.println("部门编号：" + deptno + "   部门名称：" + dname + "     部门位置：" + loc);
                }
                util.close();
            } else if (flag == 3) {
                //删除操作
                ps = util.createps(sql_4);
                System.out.println("*******请输入部门编号*******");
                deptno = request.next();
                ps.setInt(1, Integer.valueOf(deptno));
                flag = ps.executeUpdate();
                if (flag == 1) {
                    System.out.println("部门删除成功");
                } else {
                    System.out.println("部门删除失败");
                }
                util.close();
            } else {
                //更新操作
                ps = util.createps(sql_5);
                System.out.println("*******请输入部门编号*******");
                deptno = request.next();
                System.out.println("*******请输入部门名称*******");
                dname = request.next();
                System.out.println("*******请输入部门位置*******");
                loc = request.next();

                ps.setString(1, dname);
                ps.setString(2, loc);
                ps.setInt(3, Integer.valueOf(deptno));

                flag = ps.executeUpdate();
                if (flag == 1) {
                    System.out.println("部门更新成功");
                } else {
                    System.out.println("部门更新失败");
                }
                util.close();                                           //销毁资源
            }
            //具体功能页面-end

            //返回上一级功能while(true){}
            System.out.println("返回上一级菜单请按任意数字键，退出系统请按0");
            flag = request.nextInt();
            if (flag==0) {
                System.out.println("系统正在关闭中！！！");
                if (util.createCon() != null) {
                    util.close();
                }
                System.out.println("谢谢使用，系统已关闭");
                break;
            }
        }
    }
}

