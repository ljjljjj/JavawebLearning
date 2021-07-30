package com.bjpowernode.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    //静态块赋值
    private static SqlSessionFactory factory = null;
    //SqlSessionFactory比较重只创建一个，使用static静态块
    static {
        String config = "mybatis.xml";//
        try {
            InputStream in = Resources.getResourceAsStream(config);//读文件
            //创建SqlSessionFactory对象，使用SqlSessionFactoryBuilder
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
        //获取SqlSession的方法，
    public  static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        if (factory != null) {
            sqlSession=factory.openSession();//非自动提交事务
        }
        return sqlSession;
    }

}
