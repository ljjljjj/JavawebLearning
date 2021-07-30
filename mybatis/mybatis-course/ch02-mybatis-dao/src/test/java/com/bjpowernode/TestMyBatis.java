package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.dao.impl.StudentDaoImpl;
import com.bjpowernode.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {
    @Test
    public void testSelectStudents(){
        StudentDao dao = new StudentDaoImpl();
        List<Student> studentList = dao.selectStudents();
        for (Student stu:studentList){
            System.out.println(stu);
        }
    }
    @Test
    public void TestInsertStudent(){
        StudentDao dao = new StudentDaoImpl();
        Student student = new Student();
        student.setId(1007);
        student.setName("二狗");
        student.setEmail("ergou@163.com");
        student.setAge(44);
        int nums = dao.insertStudent(student);
        System.out.println("添加对象的数量：" + nums);
    }
}

