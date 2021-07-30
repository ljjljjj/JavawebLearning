package com.bjpowernode.dao;

import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.domain.viewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

   public Student selectStudentById(Integer id);

   //多个参数:命名参数，在形参前加@param("自定义参数名")，在StudentDao.xml中使用
   List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param("myage") Integer age);

   viewStudent selectviewStudent(Integer id);

   int studentCount();

   //返回map
   Map<Object,Object> selectMapById(Integer id);

   //使用resultMap定义映射关系
   List<Student> selectAllStudent();

   List<MyStudent> selectAllMyStudent();

   List<MyStudent> selectDiffColProperty();

   //like：模糊查询,在Java代码指定like的内容
   List<Student> selectLikeOne(String name);

   //like：模糊查询，在mapper文件中拼接like的内容
   //name就是 李 值，在mapper中拼接 like "%" 李 "%"
   List<Student> selectLikeTwo(String name);
 }
