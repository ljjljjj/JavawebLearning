package com.bjpowernode;

import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.apache.ibatis.io.Resources.getResourceAsStream;


public class MyApp2 {

    public static void main(String[] args) throws IOException{
//使用配置好的MyBatisUtils工具类获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
//重要    指定要执行的sql语句的标识，sql映射文件中的namespace + "." +标签的id值
        String sqlId = "com.bjpowernode.dao.StudentDao" + "." + "selectStudents";
//重要    执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
//输出结果
        //studentList.forEach( stu ->System.out.println(stu));
        for (Student stu : studentList){
            System.out.println("查询的学生：" + stu);
        }
        sqlSession.close();
    }
}
