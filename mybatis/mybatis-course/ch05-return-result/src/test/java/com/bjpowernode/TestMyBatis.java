package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;

import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.domain.viewStudent;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
    public void viewStudent(){      //执行StudentDao.xml的，id为selectStudentMultiParam的sql语句
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        viewStudent student = dao.selectviewStudent(1003);

            System.out.println("学生"+ student);

        sqlSession.close();
    }
    @Test
    public void studentCount(){      //执行StudentDao.xml的，id为selectStudentMultiParam的sql语句
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        int count = dao.studentCount();

        System.out.println("学生数量："+ count);

        sqlSession.close();
    }
    @Test
    public void selectMapById(){      //执行StudentDao.xml的，id为selectStudentMultiParam的sql语句
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Map<Object,Object> map = dao.selectMapById(1001);

        System.out.println("Map=="+ map);

        sqlSession.close();
    }
    @Test
    public void testSelectAllStudents(){            //执行StudentDao.xml的，id为selectStudentById的sql语句
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);//getMapper获取指定类接口的实现类对象

        List<Student> students = dao.selectAllStudent();
        for (Student stu: students){
            System.out.println("学生"+ stu);
        }
        sqlSession.close();
    }
    @Test
    public void testselectAllMyStudent(){            //执行StudentDao.xml的，id为selectStudentById的sql语句
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);//getMapper获取指定类接口的实现类对象

        List<MyStudent> students = dao.selectAllMyStudent();
        for (MyStudent stu: students){
            System.out.println("学生="+ stu);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectDiffColProperty(){            //执行StudentDao.xml的，id为selectStudentById的sql语句
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);//getMapper获取指定类接口的实现类对象

        List<MyStudent> students = dao.selectDiffColProperty();
        for (MyStudent stu: students){
            System.out.println("学生="+ stu);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectLikeOne(){            //执行StudentDao.xml的，id为selectStudentById的sql语句
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);//getMapper获取指定类接口的实现类对象

        String name = "%李%";
        List<Student> students = dao.selectLikeOne(name);
        for (Student stu: students){
            System.out.println("学生="+ stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectLikeTwo(){            //执行StudentDao.xml的，id为selectStudentById的sql语句
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);//getMapper获取指定类接口的实现类对象

        String name = "张";
        List<Student> students = dao.selectLikeTwo(name);
        for (Student stu: students){
            System.out.println("学生="+ stu);
        }
        sqlSession.close();
    }
}

