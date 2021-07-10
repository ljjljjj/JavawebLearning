package com.bjpowernode.Dao;

import com.bjpowernode.entity.Dept;
import com.bjpowernode.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeptDao {
    public int add(String deptno,String dname,String loc){
        String sql="insert into dept(deptno,dname,loc) values(?,?,?)";
        JdbcUtil util = new JdbcUtil();
        int result=0;
        PreparedStatement ps = util.createps(sql);
        try {
            ps.setInt(1,Integer.valueOf(deptno));
            ps.setString(2,dname);
            ps.setString(3,loc);
            result = ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    public List select(){

        String sql = "select * from dept";
        JdbcUtil util = new JdbcUtil();
        PreparedStatement ps = util.createps(sql);
        ResultSet rs = null;
        List list = new ArrayList();
        try {
            rs = ps.executeQuery();                         //从数据库获取数据
            //将临时表数据行转化为实体类实例对象保管
            while (rs.next()) {
                int deptno = rs.getInt("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                Dept dept = new Dept(deptno,dname,loc);
                list.add(dept);                             //将所有数据行打包，一次输出

            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            util.close(rs);

        }
        return list;
    }

    public int delete(String deptno){
        String sql="delete from dept where deptno=?";
        JdbcUtil util = new JdbcUtil();
        int result =0;
        PreparedStatement ps = util.createps(sql);
        try {
            ps.setInt(1,Integer.valueOf(deptno));
            result = ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    public int update(String deptno,String dname,String loc){
        JdbcUtil util = new JdbcUtil();
        String sql="update dept set dname=?,loc=? where deptno=?";
        PreparedStatement ps = util.createps(sql);
        int result = 0;

        try {
            ps.setString(1,dname);
            ps.setString(2,loc);
            ps.setInt(3,Integer.valueOf(deptno));
            result = ps.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }
}



//    public int select(){
//
//        String sql = "select * from dept";
//        JdbcUtil util = new JdbcUtil();
//        PreparedStatement ps = util.createps(sql);
//        int result =0;
//        ResultSet rs = null;
//        try {
//            rs = ps.executeQuery();                         //从数据库获取数据
//            while (rs.next()) {
//                int deptno = rs.getInt("deptno");
//                String dname = rs.getString("dname");
//                String loc = rs.getString("loc");
//                System.out.println("部门编号：" + deptno + "   部门名称：" + dname + "     部门位置：" + loc);
//            }
//
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        } finally {
//            util.close();
//
//        }
//        return result;
//    }