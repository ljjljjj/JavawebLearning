package com.bjpowernode.dao;

import com.bjpowernode.entity.Users;
import com.bjpowernode.util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    //JDBC规范中，Connection创建与销毁最浪费时间，（I/O接口）

    private JdbcUtil util = new JdbcUtil();
    //用户注册
    public int add(Users users){
        String sql = "insert into users(userName,password,sex,email)"+"values(?,?,?,?)";

        PreparedStatement ps = util.createPs(sql);
        int result = 0;
        try {
            ps.setString(1, users.getUserName());
            ps.setString(2,users.getPassword());
            ps.setString(3,users.getSex());
            ps.setString(4,users.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    //重载add
    public int add(Users users, HttpServletRequest request){
        String sql = "insert into users(userName,password,sex,email)"+"values(?,?,?,?)";

        PreparedStatement ps = util.createPs(sql,request);
        int result = 0;
        try {
            ps.setString(1, users.getUserName());
            ps.setString(2,users.getPassword());
            ps.setString(3,users.getSex());
            ps.setString(4,users.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }
        return result;
    }

    //查询所有用户信息
    public List findAll(){
        String sql ="select * from users";
        PreparedStatement ps = util.createPs(sql);
        ResultSet rs = null;
        List userList = new ArrayList();
        try {
            rs = ps.executeQuery();
            //
            while(rs.next()){
                Integer userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                Users users = new Users(userId,userName,password,sex,email);
                userList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return userList;
    }

    //用户删除行为
    public int delete(String userId){
        String sql = "delete from users where userId=?";
        PreparedStatement ps = util.createPs(sql);
        int result = 0;
        try {
            ps.setInt(1,Integer.valueOf(userId));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    //查询单个用户信息
    public List select(String userId){
        String sql ="select * from users where userId=?";
        PreparedStatement ps = util.createPs(sql);
        ResultSet rs = null;
        List userList = new ArrayList();
        try {
            rs = ps.executeQuery();

                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                Users users = new Users(null,userName,password,sex,email);
                userList.add(users);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return userList;
    }

    //用户更新操作
    public int update(Users users){
        String sql = "update users set userName=?,password=?,sex=?,email=? where userId=?";
        PreparedStatement ps = util.createPs(sql);
        int result = 0;
        try {
            ps.setInt(5,Integer.valueOf(users.getUserId()));
            ps.setString(1,users.getUserName());
            ps.setString(2,users.getPassword());
            ps.setString(3,users.getSex());
            ps.setString(4,users.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
return result;
    }

    //登录验证
    public  int login(String userName,String password){
        String sql = "select count(*) from users where userName=? and password=?";
        PreparedStatement ps = util.createPs(sql);
        ResultSet rs= null;
        int result = 0;
        try {
            ps.setString(1,userName);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while (rs.next()){
                result = rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return result;
    }
}
