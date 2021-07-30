package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

   public Student selectStudentById(Integer id);

   //多个参数:命名参数，在形参前加@param("自定义参数名")，在StudentDao.xml中使用
   List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param("myage") Integer age);
   //多个参数：使用Java接口作为接口中方法的参数
   List<Student> selectMultiStudent(Student student);

   //多个参数：简单类型的，按位置查询；#{arg0} #{arg1}

   List<Student> selectMultiPosition(String name,Integer age);

   //多个参数：使用map传值
   List<Student> selectMultiByMap(Map<String ,Object> map);

   //测试使用$替换列名
   List<Student> selectUse$Order(@Param("colName") String colName);
}
