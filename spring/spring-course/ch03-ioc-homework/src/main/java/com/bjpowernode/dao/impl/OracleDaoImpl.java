package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.domain.SysUser;

public class OracleDaoImpl implements UserDao {
    @Override
    public void insertUser(SysUser user){
        System.out.println("oracle 的 insertUser");
    }
}
