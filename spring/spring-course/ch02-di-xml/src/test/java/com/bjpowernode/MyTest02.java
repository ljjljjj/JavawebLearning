package com.bjpowernode;

import com.bjpowernode.ba02.Student;
import com.bjpowernode.ba02.School;
import org.junit.Test;

public class MyTest02 {
    @Test
    public void test01(){
        Student student = new Student();
        student.setName("lisi");
        student.setAge(20);

        School school = new School();
        school.setName("动力节点");
        school.setAddress("北京");

        student.setSchool(school);
        System.out.println("student="+student);
    }
}
