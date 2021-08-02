package com.bjpowernode.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

public class JdbcUtil {
    final String url = "jdbc:mysql://localhost:3306/crm?useSSL=false";
    final String username = "root";
    final String password = "123456";
    PreparedStatement ps = null;
    Connection con = null;

    //通过全局作用域对象得到Connection---------------------------------------start
    public Connection getCon(HttpServletRequest request) {
        //1.通过请求对象，得到全局作用域对象
        ServletContext application = request.getServletContext();
        //2.从全局作用域对象得到map
        Map map = (Map) application.getAttribute("key1");
        //3.从map得到一个处于空闲状态Connection
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            con = (Connection) it.next();
            boolean flag = (boolean) map.get(con);
            if (flag == true) {                      //确认通道是否空闲
                map.put(con, false);                 //使用前转为false
                break;
            }
        }
        return con;
    }

    //重载ps
    public PreparedStatement createPs(String sql, HttpServletRequest request) {
        try {
            ps = getCon(request).prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    //通过全局作用域对象得到Connection---------------------------------------start

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //封装连接通道创建细节
    public Connection getCon() {
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    //封装交通工具类创建细节
    public PreparedStatement createPs(String sql) {
        try {
            ps = getCon().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    //ps与con销毁细节 insert，update，delete
    public void close() {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //重载close
    public void close(HttpServletRequest request) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }//使用完通道，将通道返回
        ServletContext application = request.getServletContext();
        Map map = (Map) application.getAttribute("key1");
        map.put(con, true);
    }


    public void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
