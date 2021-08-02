package com.bjpowernode;

import com.bjpowernode.service.SomeService;
import com.bjpowernode.service.imp.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class MyTest {
    @Test//正转
    public void test01(){
        SomeService service = new SomeServiceImpl();
        service.dosome();
    }

    /**
     *  spring默认创建对象的时间；在创建spring的容器（ApplicationContext）时，会创建配置文件中的所有对象。
     *  spring创建对象：默认调用的是无参构造方法
     */

    @Test
    public void test02(){
        //使用spring容器创建的对象
        //1.指定spring配置文件的名称
        String config = "beans.xml";
        //2.创建表示spring容器的对象，ApplicationContext
        //ApplicationContext就是表示spring容器，通过这个容器获取对象
        //ClassPathXmlApplicationContext:表示从类路径中加载spring的配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获得对象，要调用对象的方法
        //getBean("配置文件中的bean的id值")getBean返回Object类型，要转回期望类型
        SomeService service = (SomeService) ac.getBean("someService");
        //使用spring创建好的对象
        service.dosome();
    }
    @Test
    public void test03(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        int nums = ac.getBeanDefinitionCount();
        System.out.println("获取容器中定义的对象数量："+nums);
        String names[] = ac.getBeanDefinitionNames();
        for(String name:names){
            System.out.println(name);
        }
    }
    //获取一个非自定义的类对象
    @Test
    public void test04(){
        String config = "beans.xml";
        ApplicationContext ac= new ClassPathXmlApplicationContext(config);
        Date my = (Date) ac.getBean("mydate");
        System.out.println("Date:"+my);
    }
}
