package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.domain.SysUser;

public class UserDaoImpl implements UserDao {
    @Override
    public  void  insertUser(SysUser user){
        System.out.println("user插入到MySQL数据库");
    }
}
