package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;

import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.naming.Name;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMyBatis {
    @Test
    public void selectStudentById(){            //执行StudentDao.xml的，id为selectStudentById的sql语句
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);//getMapper获取指定类接口的实现类对象

        Student student = dao.selectStudentById(1003);
        System.out.println("student:"+student);
    }
    @Test
    public void selectStudentMultiParam(){      //执行StudentDao.xml的，id为selectStudentMultiParam的sql语句
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectMultiParam("张三",22);
        for (Student stu: students){
            System.out.println("学生"+ stu);
        }
        sqlSession.close();
    }
    @Test
    public void selectMultiStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setName("陈一");
        student.setAge(80);

        List<Student> students = dao.selectMultiStudent(student);
        for (Student stu :students){
            System.out.println("学生:" + stu);
        }
        sqlSession.close();
    }
    @Test
    public void selectMultiPosition(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectMultiPosition("李四",20);
        for (Student stu :students){
            System.out.println("学生" + stu);
        }
        sqlSession.close();
    }
    @Test
    public void selectMultiByMap(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Map<String,Object> data = new HashMap<>();
        data.put("MyName","张三");
        data.put("MyAge",80);

        List<Student> students = dao.selectMultiByMap(data);
        for (Student stu :students){
            System.out.println("学生" + stu);
        }
        sqlSession.close();
    }
    @Test
    public void selectUse$Order(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectUse$Order("email");
        for (Student stu :students){
            System.out.println("学生" + stu);
        }
        sqlSession.close();
    }
}

