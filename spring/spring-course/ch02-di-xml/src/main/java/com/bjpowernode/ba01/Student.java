package com.bjpowernode.ba01;

import java.util.Date;

public class Student {
    private String name;
    private int age;

    public Student(){
        System.out.println("spring会调用类的无参构造方法创建对象");
    }

    public  void setEmail(String email){
        System.out.println("setEmail:"+email);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
