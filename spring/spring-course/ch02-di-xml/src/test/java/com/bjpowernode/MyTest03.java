package com.bjpowernode;

import com.bjpowernode.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest03 {
    @Test
    public void test03(){
        System.out.println("==========test==========");
        String config = "ba03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //从容器中获取Student对象
        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println("student对象="+myStudent);
    }
    @Test
    public void test04(){
        System.out.println("============test2=============");
        String config = "ba03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student myStudent2 = (Student) ac.getBean("myStudent2");

        System.out.println("student对象=" +myStudent2);
    }
}
