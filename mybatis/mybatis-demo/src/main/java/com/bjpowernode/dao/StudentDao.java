package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

//接口操作student表
public interface StudentDao {
    //查询student表的所有数据
    public List<Student> selectStudents();
    //插入
    public int insertStudent(Student student);
}
