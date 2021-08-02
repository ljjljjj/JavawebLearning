package com.bjpowernode;

import com.bjpowernode.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {

    @Test
    public void test01(){
        String config = "ba01/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student mystudent = (Student) ac.getBean("mystudent");
        System.out.println("student对象："+mystudent);
        mystudent.setAge(31);
        System.out.println("getAge:"+mystudent.getAge());
        Date myDate = (Date) ac.getBean("mydate");
        System.out.println("myDate="+myDate);
    }
}
