package com.bjpowernode.test;

import com.bjpowernode.Dao.DeptDao;
import com.bjpowernode.entity.Dept;

import java.util.List;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String deptno,dname,loc;
        int flag = 0;
        DeptDao dao = new DeptDao();
        System.out.println("*********欢迎使用部门管理系统**********");
        System.out.println("*******1.添加部门*******");
        System.out.println("*******2.查询部门*******");
        System.out.println("*******3.删除部门*******");
        System.out.println("*******4.更新部门*******");
        System.out.println("*******请输入操作*******");
        flag = scanner.nextInt();

        if (flag==1){
            System.out.println("请输入新部门编号");
            deptno = scanner.next();
            System.out.println("请输入新部门名称");
            dname = scanner.next();
            System.out.println("请输入新部门位置");
            loc = scanner.next();
            flag = dao.add(deptno,dname,loc);

            if (flag==1){
                System.out.println("新部门添加成功！");
            }else {
                System.out.println("新部门添加失败！");
            }
        }else if (flag==2){
            List<Dept> deptList = dao.select();
            for(Dept dept:deptList){
            System.out.println("部门编号：" +dept.getDeptno() + "   部门名称：" + dept.getDname() + "     部门位置：" + dept.getLoc());
            }
        }else if (flag==3){
            System.out.println("请输入需要删除的部门编号");
            deptno = scanner.next();
            flag = dao.delete(deptno);
            if (flag ==1){
                System.out.println("部门删除成功！");
            }else {
                System.out.println("部门删除失败！");
            }
        }else{
            System.out.println("请输入原始部门编号");
            deptno = scanner.next();
            System.out.println("请输入新部门名称");
            dname = scanner.next();
            System.out.println("请输入新部门位置");
            loc = scanner.next();
            flag = dao.update(deptno,dname,loc);
            if (flag ==1){
                System.out.println("新部门更新成功！");
            }else {
                System.out.println("新部门更新失败！");
            }
        }

    }
}
