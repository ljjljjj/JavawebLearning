package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    List<Student> selectStudentIf(Student student);

    List<Student> selectStudentWhere(Student student);

    //foreach用法一
    List<Student> selectForeachOne(List<Integer> idlist);

    //foreach用法二
    List<Student> selectForeachTwo(List<Student> stulist);

    //使用PageHelper分页数据
    List<Student> selectAll();
}