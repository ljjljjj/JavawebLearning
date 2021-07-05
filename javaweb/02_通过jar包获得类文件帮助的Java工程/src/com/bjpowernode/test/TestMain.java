package com.bjpowernode.test;

import com.bjpowernode.entity.Dept;

public class TestMain {
    public static void main(String[] args) {
        Dept dept = new Dept(10,"金融融合部门","北京");
        System.out.println("部门名称：" + dept.getdName());
        System.out.println("部门编号：" + dept.getDeptNo());
        System.out.println("部门位置：" + dept.getLoc());
    }
}
