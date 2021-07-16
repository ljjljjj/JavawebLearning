package com.bjpowernode.util;

import java.sql.*;

public class JdbcUtil {
     final String url="jdbc:mysql://localhost:3306/crm?useSSL=false";
     final String username="root";
     final String password="123456";
     PreparedStatement ps = null;
     Connection con = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        //封装连接通道创建细节
        public Connection getCon(){
            try {
                con = DriverManager.getConnection(url,username,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return con;
        }
        //封装交通工具类创建细节
        public PreparedStatement createPs(String sql){
            try {
                ps = getCon().prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return ps;
        }
        //ps与con销毁细节 insert，update，delete
    public void close(){
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
