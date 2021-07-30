package com.bjpowernode.domain;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

public class TestMybatis {
    public static void main(String[] args) throws IOException {
        String config= "mybatis.xml";

        InputStream in = getResourceAsStream(config);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(in);

        //SqlSession sqlSession = factory.openSession();//非自动

        SqlSession sqlSession = factory.openSession(true);//自动
        String sqlId = "com.bjpowernode.dao.StudentDao.insertStudent";

        Student student = new Student();
        student.setId(1006);
        student.setName("孙八");
        student.setEmail("sunba@foxmail.com");
        student.setAge(80);

        int nums = sqlSession.insert(sqlId,student);
        //mybatis不支持自动提交，需要在insert、delete、update中手动提交
        //sqlSession.commit();

        System.out.println("执行insert的结果：" + nums);

        sqlSession.close();
    }
}
